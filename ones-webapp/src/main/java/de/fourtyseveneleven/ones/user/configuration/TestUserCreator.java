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

import java.util.UUID;

@Component
@Profile({"development", "staging"})
public class TestUserCreator
        implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOG =
            LoggerFactory.getLogger(TestUserCreator.class);

    private static final String TEST_USER_EMAIL_ADDRESS = "ones@example.com";
    private static final String TEST_USER_UUID = "4bfb14cd-cb0a-4c74-b9a3-dd136bae60cf";
    private static final String TEST_USER_PASSWORD = "ones";

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public TestUserCreator(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent e) {

        createTestUserIfNecessary();
    }

    private void createTestUserIfNecessary() {

        if (shouldCreateTestUser()) {
            createTestUser();
        }
    }

    private boolean shouldCreateTestUser() {

        return userRepository.findAll().isEmpty();
    }

    private void createTestUser() {

        LOG.info("Creating test user...");
        final User testUser = buildTestUser();
        userRepository.save(testUser);
        LOG.info("Successfully created test user.");
    }

    private User buildTestUser() {

        final var testUser = new User();
        testUser.setEmailAddress(TEST_USER_EMAIL_ADDRESS);
        testUser.setUuid(UUID.fromString(TEST_USER_UUID));
        testUser.setPassword(passwordEncoder.encode(TEST_USER_PASSWORD));
        testUser.setRegistrationConfirmed(true);

        return testUser;
    }
}