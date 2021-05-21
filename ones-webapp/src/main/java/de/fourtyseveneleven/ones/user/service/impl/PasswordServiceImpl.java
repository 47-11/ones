package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.user.exception.ForgotPasswordException;
import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.repository.ForgotPasswordRequestRepository;
import de.fourtyseveneleven.ones.user.service.ForgotPasswordMessageService;
import de.fourtyseveneleven.ones.user.service.PasswordService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.time.LocalDateTime;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.Objects.isNull;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final UserService userService;
    private final ForgotPasswordRequestRepository forgotPasswordRequestRepository;
    private final ForgotPasswordMessageService forgotPasswordMessageService;
    private final PasswordEncoder passwordEncoder;

    private final SecureRandom secureRandom = new SecureRandom();

    public PasswordServiceImpl(UserService userService, ForgotPasswordRequestRepository forgotPasswordRequestRepository, ForgotPasswordMessageService forgotPasswordMessageService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.forgotPasswordRequestRepository = forgotPasswordRequestRepository;
        this.forgotPasswordMessageService = forgotPasswordMessageService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

        final var user = getAuthenticatedUser();
        checkOldPassword(oldPassword, user);
        doChangePassword(user, newPassword);
    }

    private void checkOldPassword(String oldPassword, User user) {

        final boolean passwordMatches = passwordMatches(oldPassword, user);
        if (!passwordMatches) {
            throw new BadCredentialsException(getExceptionMessage("password-change.old-password-wrong"));
        }
    }

    private boolean passwordMatches(String password, User user) {

        return passwordEncoder.matches(password, user.getPassword());
    }

    private void doChangePassword(User user, String newPassword) {

        final String encodedPassword = encodePassword(newPassword);
        user.setPassword(encodedPassword);
        userService.updateUser(user);
    }

    private String encodePassword(String rawPassword) {

        return passwordEncoder.encode(rawPassword);
    }

    @Override
    @Transactional
    public void forgotPassword(String emailAddress) {

        final User user = userService.findOneByEmailAddress(emailAddress).orElseThrow(ElementNotFoundException::new);
        final var forgotPasswordRequest = createForgotPasswordRequest(user);
        forgotPasswordMessageService.sendForgotPasswordMessage(forgotPasswordRequest);
    }

    private ForgotPasswordRequest createForgotPasswordRequest(User user){

        final var forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setUser(user);
        forgotPasswordRequest.setConfirmationCode(newConfirmationCode());
        forgotPasswordRequest.setValidUntil(getValidUntil());

        return forgotPasswordRequestRepository.save(forgotPasswordRequest);
    }

    private LocalDateTime getValidUntil() {

        return LocalDateTime.now().plusDays(1);
    }

    private String newConfirmationCode() {

        return RandomStringUtils.random(255, 0, 0, true, true, null, secureRandom);
    }

    @Override
    @Transactional
    public void forgotPasswordSetNewPassword(String confirmationCode, String newPassword) {

        final var forgotPasswordRequest = getValidForgotPasswordRequest(confirmationCode);

        final var user = forgotPasswordRequest.getUser();
        doChangePassword(user, newPassword);

        invalidateForgotPasswordRequest(forgotPasswordRequest);
    }

    private ForgotPasswordRequest getValidForgotPasswordRequest(String confirmationCode) {

        final var forgotPasswordRequest = forgotPasswordRequestRepository.findOneByConfirmationCode(confirmationCode)
                .orElseThrow(() -> new ForgotPasswordException(getExceptionMessage("forgot-password.code-invalid")));

        verifyForgotPasswordRequest(forgotPasswordRequest);

        return forgotPasswordRequest;
    }

    private void verifyForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest) {

        if (isNull(forgotPasswordRequest.getValidUntil())) {
            throw new ForgotPasswordException(getExceptionMessage("forgot-password.code-already-used"));
        }

        if (LocalDateTime.now().isAfter(forgotPasswordRequest.getValidUntil())) {
            throw new ForgotPasswordException(getExceptionMessage("forgot-password.code-expired"));
        }
    }

    private void invalidateForgotPasswordRequest(ForgotPasswordRequest forgotPasswordRequest) {

        forgotPasswordRequest.setValidUntil(null);
        forgotPasswordRequestRepository.save(forgotPasswordRequest);
    }
}
