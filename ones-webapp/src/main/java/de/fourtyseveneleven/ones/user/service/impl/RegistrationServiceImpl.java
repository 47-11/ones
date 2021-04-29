package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.service.RegistrationConfirmationMessageService;
import de.fourtyseveneleven.ones.user.service.RegistrationService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);

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
    public void createRegistration(RegistrationDto registrationDto) {

        final User user = createNewUser(registrationDto);
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
