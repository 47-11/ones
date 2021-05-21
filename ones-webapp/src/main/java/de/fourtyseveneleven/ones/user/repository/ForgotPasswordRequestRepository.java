package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForgotPasswordRequestRepository extends JpaRepository<ForgotPasswordRequest, Long> {

    Optional<ForgotPasswordRequest> findOneByConfirmationCode(String confirmationCode);
}
