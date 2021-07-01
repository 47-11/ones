package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
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
    private final EcmRegistrationService ecmRegistrationService;

    private final SecureRandom secureRandom = new SecureRandom();

    public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserService userService,
                                   RegistrationConfirmationMessageService registrationConfirmationMessageService, ApplicationAccountControllerApi applicationAccountControllerApi, EcmRegistrationService ecmRegistrationService) {

        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.registrationConfirmationMessageService = registrationConfirmationMessageService;
        this.ecmRegistrationService = ecmRegistrationService;
    }

    @Override
    @Transactional
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
            registerUserInEcm(user, vddMemberNumber);
        }
    }

    private void registerUserInEcm(User user, int vddMemberNumber) {

        final UUID uuid = ecmRegistrationService.registerExistingMember(user, vddMemberNumber);
        user.setUuid(uuid);
        userService.updateUser(user);
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
