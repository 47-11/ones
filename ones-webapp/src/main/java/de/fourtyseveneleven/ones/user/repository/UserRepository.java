package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneById(long id);

    Optional<User> findOneByEmailAddress(String emailAddress);

    Optional<User> findOneByRegistrationConfirmationCodeAndRegistrationConfirmedIsFalse(String registrationConfirmationCode);
}
