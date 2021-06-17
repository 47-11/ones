package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractValidationTestIT;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

        user.setEmailAddress("");
        assertValidationFails(user);

        user.setEmailAddress("   \n  \t  \r");
        assertValidationFails(user);

        user.setEmailAddress(null);
        assertValidationFails(user);
    }

    @Test
    void emailAddressIsValidEmail() {

        final User user = buildValidEntity();

        user.setEmailAddress("dies ist keine E-Mail-Adresse!");
        assertValidationFails(user);

        user.setEmailAddress("test+ones@example.com");
        assertValidationSucceeds(user);
    }

    @Test
    void emailAddressSize() {

        final User user = buildValidEntity();
        user.setEmailAddress("X".repeat(256));
        assertValidationFails(user);
    }

    @Test
    void passwordNotBlank() {

        final User user = buildValidEntity();

        user.setPassword("");
        assertValidationFails(user);

        user.setPassword("   \n  \t  \r");
        assertValidationFails(user);

        user.setPassword(null);
        assertValidationFails(user);
    }

    @Test
    void passwordSize() {

        final User user = buildValidEntity();
        user.setPassword("*".repeat(61));
        assertValidationFails(user);
    }

    @Test
    void registrationConfirmationCodeSize() {

        final User user = buildValidEntity();
        user.setRegistrationConfirmationCode("*".repeat(254));
        assertValidationFails(user);

        user.setRegistrationConfirmationCode("*".repeat(256));
        assertValidationFails(user);
    }
}
