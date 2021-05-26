package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.common.repository.AbstractRepositoryTestIT;
import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Objects.isNull;

class ForgotPasswordRepositoryTestIT extends AbstractRepositoryTestIT<ForgotPasswordRequest> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ForgotPasswordRequestRepository forgotPasswordRequestRepository;

    private User user;

    @Override
    protected JpaRepository<ForgotPasswordRequest, Long> getRepository() {
        return forgotPasswordRequestRepository;
    }

    @Override
    protected ForgotPasswordRequest getTestEntity() {

        final var forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setUser(getUser());
        forgotPasswordRequest.setConfirmationCode("*".repeat(255));
        forgotPasswordRequest.setValidUntil(LocalDateTime.now());
        return forgotPasswordRequest;
    }

    private User getUser() {

        if (isNull(user)) {
            createUser();
        }

        return user;
    }

    private void createUser() {

        final var newUser = new User();
        newUser.setEmailAddress("test@example.com");
        newUser.setPassword("password");
        newUser.setRegistrationConfirmed(true);

        this.user = userRepository.save(newUser);
    }
}
