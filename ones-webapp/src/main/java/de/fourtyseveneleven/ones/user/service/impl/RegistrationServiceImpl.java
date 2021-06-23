package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount4Member;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
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
import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RegistrationConfirmationMessageService registrationConfirmationMessageService;
    private final ApplicationAccountControllerApi applicationAccountControllerApi;

    private final SecureRandom secureRandom = new SecureRandom();

    public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserService userService,
                                   RegistrationConfirmationMessageService registrationConfirmationMessageService, ApplicationAccountControllerApi applicationAccountControllerApi) {

        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.registrationConfirmationMessageService = registrationConfirmationMessageService;
        this.applicationAccountControllerApi = applicationAccountControllerApi;
    }

    @Override
    public void createRegistration(RegistrationDto registrationDto) {

        final User user = createNewUser(registrationDto);
        registerUserInEcmIfNecessary(user, registrationDto);
        sendRegistrationEmail(user);
    }

    private User createNewUser(RegistrationDto registrationDto) {

        try {
            return doCreateUser(registrationDto);
        } catch (ElementAlreadyPresentException e) {
            throw new RegistrationException(getExceptionMessage("registration.email-address-already-in-use", registrationDto.getEmailAddress()), e);
        }
    }

    private User doCreateUser(RegistrationDto registrationDto) {

        final var user = new User();
        user.setEmailAddress(registrationDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRegistrationConfirmed(false);
        user.setRegistrationConfirmationCode(newRegistrationConfirmationCode());

        return userService.createNewUser(user);
    }

    private String newRegistrationConfirmationCode() {

        return RandomStringUtils.random(255, 0, 0, true, true, null, secureRandom);
    }

    private void registerUserInEcmIfNecessary(User user, RegistrationDto registrationDto) {

        final Integer vddMemberNumber = registrationDto.getVddMemberNumber();
        if (nonNull(vddMemberNumber)) {
            doRegisterUserInEcm(user, vddMemberNumber);
        }
    }

    private void doRegisterUserInEcm(User user, int vddMemberNumber) {

        final RegisterAccount4Member registerAccount4Member = new RegisterAccount4Member();
        registerAccount4Member.setEmail(user.getEmailAddress());
        registerAccount4Member.setVddMemberNumber(vddMemberNumber);

        doRegisterUserInEcm(registerAccount4Member, user);
    }

    private void doRegisterUserInEcm(RegisterAccount4Member registerAccount4Member, User user) {

        final RegisterResponce registerResponce = tryPostRegisterAccount4Member(registerAccount4Member);
        if (isRegistrationSuccessful(registerResponce)) {
            handleSuccessfulRegistration(user, registerResponce);
        } else {
            throw new RegistrationException(getExceptionMessage("registration.ecm-registration-failed"));
        }
    }

    private RegisterResponce tryPostRegisterAccount4Member(RegisterAccount4Member registerAccount4Member) {

        try {
            return applicationAccountControllerApi.postRegisterAccount4Member(registerAccount4Member);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    private boolean isRegistrationSuccessful(RegisterResponce registerResponce) {

        final Integer reasonCode = registerResponce.getReasonCode();
        final boolean successfulReasonCode = isNull(reasonCode) || reasonCode == 0;
        final boolean successfulState = "CREATED".equalsIgnoreCase(registerResponce.getState());
        return successfulReasonCode && successfulState;
    }

    private void handleSuccessfulRegistration(User user, RegisterResponce registerResponce) {

        final String uuid = registerResponce.getRegisterObjectUuid();
        if (isBlank(uuid)) {
            final String exceptionMessage = format("Successful registration response without uuid. User: {0} / Response: {1}", user, registerResponce);
            throw new IllegalStateException(exceptionMessage);
        } else {
            user.setUuid(UUID.fromString(uuid));
            userService.updateUser(user);
        }
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
