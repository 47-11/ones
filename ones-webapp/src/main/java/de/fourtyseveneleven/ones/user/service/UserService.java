package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.SetPersonalDataRequest;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneByEmailAddress(String emailAddress);

    User createNewUser(User newUser);

    User updateUser(User updatedUser);

    UserDto getCurrentUser();

    boolean existsByEmailAddress(String emailAddress);

    void setPersonalData(SetPersonalDataRequest request);

    void updatePersonalData(UserDto personalData);

    void deleteSelf();
}
