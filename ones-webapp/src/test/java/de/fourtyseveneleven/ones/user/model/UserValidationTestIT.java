package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractValidationTestIT;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserValidationTestIT extends AbstractValidationTestIT<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    protected User buildValidEntity() {
        final var user = new User();
        user.setEmailAddress("foo@example.com");
        user.setPassword("*".repeat(60));
        user.setRegistrationConfirmationCode("*".repeat(255));
        return user;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Test
    void emailAddressNotBlank() {

        final User user = buildValidEntity();
        final String expectedMessage = "E-Mail address must not be blank.";

        user.setEmailAddress("");
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setEmailAddress(null);
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setEmailAddress("   \n  \t  \r");
        assertValidationFailsWithMessages(user, expectedMessage, "E-Mail address must be a valid E-Mail address.");
    }

    @Test
    void emailAddressIsValidEmail() {

        final User user = buildValidEntity();

        user.setEmailAddress("dies ist keine E-Mail-Adresse!");
        assertValidationFailsWithMessages(user, "E-Mail address must be a valid E-Mail address.");

        user.setEmailAddress("test+ones@example.com");
        assertValidationSucceeds(user);
    }

    @Test
    void emailAddressSize() {

        final User user = buildValidEntity();
        user.setEmailAddress("X".repeat(256));
        assertValidationFailsWithMessages(user, "E-Mail address must not be longer than 255 characters.", "E-Mail address must be a valid E-Mail address.");
    }

    @Test
    void passwordNotBlank() {

        final User user = buildValidEntity();
        final String expectedMessage = "Password must not be blank.";

        user.setPassword(" ".repeat(60));
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setPassword("\n\t\r".repeat(20));
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setPassword(null);
        assertValidationFailsWithMessages(user, expectedMessage);
    }

    @Test
    void passwordSize() {

        final User user = buildValidEntity();
        final String expectedMessage = "Password hash is not valid. Should be 60 characters long.";

        user.setPassword("*".repeat(61));
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setPassword("*".repeat(59));
        assertValidationFailsWithMessages(user, expectedMessage);
    }

    @Test
    void registrationConfirmationCodeSize() {

        final User user = buildValidEntity();
        final String expectedMessage = "Generated confirmation code is not valid. Should be 255 characters long.";

        user.setRegistrationConfirmationCode("*".repeat(254));
        assertValidationFailsWithMessages(user, expectedMessage);

        user.setRegistrationConfirmationCode("*".repeat(256));
        assertValidationFailsWithMessages(user, expectedMessage);
    }
}
