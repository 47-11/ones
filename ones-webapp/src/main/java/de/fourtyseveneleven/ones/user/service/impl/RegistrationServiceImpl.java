package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import de.fourtyseveneleven.ones.user.service.RegistrationConfirmationMessageService;
import de.fourtyseveneleven.ones.user.service.RegistrationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationConfirmationMessageService registrationConfirmationMessageService;

    private final SecureRandom secureRandom = new SecureRandom();

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RegistrationConfirmationMessageService registrationConfirmationMessageService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.registrationConfirmationMessageService = registrationConfirmationMessageService;
    }

    @Override
    @Transactional
    public void createRegistration(RegistrationDto registrationDto) {

        requireNewUser(registrationDto);
        final User user = createUser(registrationDto);
        sendRegistrationEmail(user);
    }

    private void requireNewUser(RegistrationDto registrationDto) {

        final Optional<User> existingUser = userRepository.findOneByEmailAddress(registrationDto.getEmailAddress());
        if (existingUser.isPresent()) {
            throw new RegistrationException(getExceptionMessage("registration.email-address-already-in-use", registrationDto.getEmailAddress()));
        }
    }

    private User createUser(RegistrationDto registrationDto) {

        final var user = new User();
        user.setEmailAddress(registrationDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRegistrationConfirmed(false);
        user.setRegistrationConfirmationCode(newRegistrationConfirmationCode());

        return userRepository.save(user);
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

        final User user = userRepository.findOneByRegistrationConfirmationCodeAndRegistrationConfirmedIsFalse(registrationConfirmationCode)
                .orElseThrow(() -> new RegistrationException(getExceptionMessage("registration.confirmation.invalid-code")));
        user.setRegistrationConfirmed(true);
        user.setRegistrationConfirmationCode(null);
        userRepository.save(user);
    }
}
