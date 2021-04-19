package de.fourtyseveneleven.ones.repository;

import de.fourtyseveneleven.ones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmailAddress(String emailAddress);
}
