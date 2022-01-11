package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.model.UserRegistration;
import de.fourtyseveneleven.ones.user.model.dto.EmailPasswordDto;
import de.fourtyseveneleven.ones.user.repository.UserRegistrationRepository;
import de.fourtyseveneleven.ones.user.service.RegistrationConfirmationMessageService;
import de.fourtyseveneleven.ones.user.service.RegistrationService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RegistrationConfirmationMessageService registrationConfirmationMessageService;

    private final SecureRandom secureRandom = new SecureRandom();

    public RegistrationServiceImpl(UserRegistrationRepository userRegistrationRepository, PasswordEncoder passwordEncoder, UserService userService,
                                   RegistrationConfirmationMessageService registrationConfirmationMessageService) {

        this.userRegistrationRepository = userRegistrationRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.registrationConfirmationMessageService = registrationConfirmationMessageService;
    }

    @Override
    @Transactional
    public void createRegistration(EmailPasswordDto emailPasswordDto) {

        requireNewUser(emailPasswordDto.emailAddress());
        final UserRegistration registration = doCreateRegistration(emailPasswordDto);
        sendRegistrationEmail(registration);
    }

    private void requireNewUser(String emailAddress) {

        final boolean emailAddressAlreadyUsed = isEmailAddressAlreadyUsed(emailAddress);
        if (emailAddressAlreadyUsed) {
            throw new RegistrationException(getExceptionMessage("registration.email-address-already-in-use", emailAddress));
        }
    }

    private boolean isEmailAddressAlreadyUsed(String emailAddress) {

        final boolean existingRegistration =  userRegistrationRepository.existsByEmailAddress(emailAddress);
        final boolean existingUser = userService.existsByEmailAddress(emailAddress);
        return existingRegistration || existingUser;
    }

    private UserRegistration doCreateRegistration(EmailPasswordDto emailPasswordDto) {

        final var registration = new UserRegistration();
        registration.setEmailAddress(emailPasswordDto.emailAddress());
        registration.setPassword(passwordEncoder.encode(emailPasswordDto.password()));
        registration.setConfirmationCode(newRegistrationConfirmationCode());

        return userRegistrationRepository.save(registration);
    }

    private String newRegistrationConfirmationCode() {

        return RandomStringUtils.random(255, 0, 0, true, true, null, secureRandom);
    }

    private void sendRegistrationEmail(UserRegistration registration) {

        registrationConfirmationMessageService.sendRegistrationConfirmationMessage(registration);
    }

    @Override
    @Transactional
    public void confirmRegistration(String registrationConfirmationCode) {

        final UserRegistration userRegistration = userRegistrationRepository.findOneByConfirmationCode(registrationConfirmationCode)
                .orElseThrow(() -> new RegistrationException(getExceptionMessage("registration.confirmation.invalid-code")));

        createUser(userRegistration);
        userRegistrationRepository.delete(userRegistration);
    }

    private void createUser(UserRegistration registration) {

        final var user = new User();
        user.setEmailAddress(registration.getEmailAddress());
        user.setPassword(registration.getPassword());

        userService.createNewUser(user);
    }
}
