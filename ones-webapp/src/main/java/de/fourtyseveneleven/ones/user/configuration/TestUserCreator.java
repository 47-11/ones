package de.fourtyseveneleven.ones.user.configuration;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Profile({"development", "staging"})
public class TestUserCreator
        implements ApplicationListener<ApplicationReadyEvent> {

    private static final String TEST_USER_ONE_EMAIL_ADDRESS = "ones@example.com";
    private static final String TEST_USER_TWO_EMAIL_ADDRESS = "twos@example.com";
    private static final String TEST_USER_PASSWORD = "ones";

    private static final Logger LOG =
            LoggerFactory.getLogger(TestUserCreator.class);

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public TestUserCreator(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent e) {

        createTestUsersIfNecessary();
    }

    private void createTestUsersIfNecessary() {

        if (shouldCreateTestUsers()) {
            createTestUsers();
        }
    }

    private boolean shouldCreateTestUsers() {

        return userRepository.findAll().isEmpty();
    }

    private void createTestUsers() {

        LOG.info("Creating test users...");
        createTestUserOne();
        createTestUserTwo();
        LOG.info("Successfully created test users.");
    }

    private void createTestUserOne() {

        final User testUserOne = buildTestUserOne();
        userRepository.save(testUserOne);
    }

    private User buildTestUserOne() {

        final var testUser = new User();
        testUser.setEmailAddress(TEST_USER_ONE_EMAIL_ADDRESS);
        testUser.setPassword(passwordEncoder.encode(TEST_USER_PASSWORD));
        testUser.setRegistrationConfirmed(true);
        testUser.setUuid(null);

        return testUser;
    }

    private void createTestUserTwo() {

        final User testUserTwo = buildTestUserTwo();
        userRepository.save(testUserTwo);
    }

    private User buildTestUserTwo() {

        final var testUser = new User();
        testUser.setEmailAddress(TEST_USER_TWO_EMAIL_ADDRESS);
        testUser.setPassword(passwordEncoder.encode(TEST_USER_PASSWORD));
        testUser.setRegistrationConfirmed(true);
        testUser.setUuid(UUID.randomUUID());

        return testUser;
    }
}