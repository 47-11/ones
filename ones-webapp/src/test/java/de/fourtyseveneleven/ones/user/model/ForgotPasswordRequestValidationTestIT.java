package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractValidationTestIT;
import de.fourtyseveneleven.ones.user.repository.ForgotPasswordRequestRepository;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ForgotPasswordRequestValidationTestIT extends AbstractValidationTestIT<ForgotPasswordRequest> {

    @Autowired
    ForgotPasswordRequestRepository forgotPasswordRequestRepository;

    @Autowired
    UserRepository userRepository;

    private User testUser;

    @BeforeEach
    @Override
    protected void setUp() {
        super.setUp();

        userRepository.deleteAll();

        final var user = new User();
        user.setEmailAddress("foo@example.com");
        user.setPassword("*".repeat(60));
        this.testUser = userRepository.save(user);
    }

    @AfterEach
    @Override
    protected void tearDown() {
        super.tearDown();

        userRepository.deleteAll();
    }

    @Override
    protected ForgotPasswordRequest buildValidEntity() {
        super.tearDown();

        final var forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setUser(testUser);
        forgotPasswordRequest.setConfirmationCode("*".repeat(255));

        return forgotPasswordRequest;
    }

    @Override
    protected JpaRepository<ForgotPasswordRequest, Long> getRepository() {
        return forgotPasswordRequestRepository;
    }

    @Test
    void userNotNull() {

        final var forgotPasswordRequest = buildValidEntity();
        forgotPasswordRequest.setUser(null);
        assertValidationFailsWithMessages(forgotPasswordRequest, "User must not be null.");
    }

    @Test
    void confirmationCodeNotBlank() {

        final var forgotPasswordRequest = buildValidEntity();
        final String expectedMessage = "Generated confirmation code is not valid. Should be 255 characters long.";

        forgotPasswordRequest.setConfirmationCode(" ".repeat(255));
        assertValidationFailsWithMessages(forgotPasswordRequest, expectedMessage);

        forgotPasswordRequest.setConfirmationCode("\n\t\r".repeat(85));
        assertValidationFailsWithMessages(forgotPasswordRequest, expectedMessage);

        forgotPasswordRequest.setConfirmationCode(null);
        assertValidationFailsWithMessages(forgotPasswordRequest, expectedMessage);
    }

    @Test
    void ConfirmationCodeSize() {

        final var forgotPasswordRequest = buildValidEntity();
        final String expectedMessage = "Generated confirmation code is not valid. Should be 255 characters long.";

        forgotPasswordRequest.setConfirmationCode("*".repeat(254));
        assertValidationFailsWithMessages(forgotPasswordRequest, expectedMessage);

        forgotPasswordRequest.setConfirmationCode("*".repeat(256));
        assertValidationFailsWithMessages(forgotPasswordRequest, expectedMessage);
    }
}
