package de.fourtyseveneleven.ones.repository;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepositoryTestIT extends AbstractRepositoryTestIT<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    JpaRepository<User, Long> getRepository() {

        return userRepository;
    }

    @Override
    User getTestEntity(long id) {

        final var user = new User();
        user.setId(id);
        user.setEmailAddress("testy@mctesticles.de");
        user.setPassword("some-pw-hash");
        return user;
    }
}
