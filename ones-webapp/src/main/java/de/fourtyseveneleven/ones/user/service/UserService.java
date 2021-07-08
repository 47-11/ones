package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.PersonalDataDto;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneByEmailAddress(String emailAddress);

    Optional<User> findByIncompleteRegistration(String registrationConfirmationCode);

    User createNewUser(User newUser);

    User updateUser(User updatedUser);

    UserDto getCurrentUser();

    void setPersonalDataForCurrentUser(PersonalDataDto personalDataDto);
}
