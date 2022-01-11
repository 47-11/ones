package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.user.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

    Optional<UserRegistration> findOneByEmailAddress(String emailAddress);

    Optional<UserRegistration> findOneByConfirmationCode(String confirmationCode);
}
