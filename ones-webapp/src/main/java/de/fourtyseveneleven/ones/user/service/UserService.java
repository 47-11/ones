package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneByEmailAddress(String emailAddress);

    Optional<User> findByIncompleteRegistration(String registrationConfirmationCode);

    User createNewUser(User newUser);

    User updateUser(User updatedUser);
}
