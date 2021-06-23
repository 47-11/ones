package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.common.repository.AbstractRepositoryTestIT;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepositoryTestIT extends AbstractRepositoryTestIT<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    protected JpaRepository<User, Long> getRepository() {

        return userRepository;
    }

    @Override
    protected User getTestEntity() {

        final var user = new User();
        user.setEmailAddress("testy@mctesticles.de");
        user.setPassword("*".repeat(60));
        return user;
    }
}
