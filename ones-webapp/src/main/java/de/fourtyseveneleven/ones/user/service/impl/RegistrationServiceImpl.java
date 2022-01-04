package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.model.dto.EmailPasswordDto;
import de.fourtyseveneleven.ones.user.service.EcmRegistrationService;
import de.fourtyseveneleven.ones.user.service.RegistrationConfirmationMessageService;
import de.fourtyseveneleven.ones.user.service.RegistrationService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.UUID;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.util.Objects.nonNull;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RegistrationConfirmationMessageService registrationConfirmationMessageService;

    private final SecureRandom secureRandom = new SecureRandom();

    public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserService userService,
                                   RegistrationConfirmationMessageService registrationConfirmationMessageService) {

        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.registrationConfirmationMessageService = registrationConfirmationMessageService;
    }

    @Override
    @Transactional
    public void createRegistration(EmailPasswordDto emailPasswordDto) {

        final User user = createNewUser(emailPasswordDto);
        sendRegistrationEmail(user);
    }

    private User createNewUser(EmailPasswordDto emailPasswordDto) {

        try {
            return doCreateUser(emailPasswordDto);
        } catch (ElementAlreadyPresentException e) {
            throw new RegistrationException(getExceptionMessage("registration.email-address-already-in-use", emailPasswordDto.emailAddress()), e);
        }
    }

    private User doCreateUser(EmailPasswordDto emailPasswordDto) {

        final var user = new User();
        user.setEmailAddress(emailPasswordDto.emailAddress());
        user.setPassword(passwordEncoder.encode(emailPasswordDto.password()));
        user.setRegistrationConfirmed(false);
        user.setRegistrationConfirmationCode(newRegistrationConfirmationCode());

        return userService.createNewUser(user);
    }

    private String newRegistrationConfirmationCode() {

        return RandomStringUtils.random(255, 0, 0, true, true, null, secureRandom);
    }

    private void sendRegistrationEmail(User user) {

        registrationConfirmationMessageService.sendRegistrationConfirmationMessage(user);
    }

    @Override
    @Transactional
    public void confirmRegistration(String registrationConfirmationCode) {

        final User user = userService.findByIncompleteRegistration(registrationConfirmationCode)
                .orElseThrow(() -> new RegistrationException(getExceptionMessage("registration.confirmation.invalid-code")));
        user.setRegistrationConfirmed(true);
        user.setRegistrationConfirmationCode(null);
        userService.updateUser(user);
    }
}
