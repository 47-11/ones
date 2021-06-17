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
        userRepository.deleteAll();

        final var user = new User();
        user.setEmailAddress("foo@example.com");
        user.setPassword("*".repeat(60));
        user.setRegistrationConfirmationCode("*".repeat(255));
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
        assertValidationFails(forgotPasswordRequest);
    }

    @Test
    void confirmationCodeNotBlank() {

        final var forgotPasswordRequest = buildValidEntity();

        forgotPasswordRequest.setConfirmationCode("");
        assertValidationFails(forgotPasswordRequest);

        forgotPasswordRequest.setConfirmationCode("   \n  \t  \r");
        assertValidationFails(forgotPasswordRequest);

        forgotPasswordRequest.setConfirmationCode(null);
        assertValidationFails(forgotPasswordRequest);
    }

    @Test
    void ConfirmationCodeSize() {

        final var forgotPasswordRequest = buildValidEntity();

        forgotPasswordRequest.setConfirmationCode("*".repeat(254));
        assertValidationFails(forgotPasswordRequest);

        forgotPasswordRequest.setConfirmationCode("*".repeat(256));
        assertValidationFails(forgotPasswordRequest);
    }
}
