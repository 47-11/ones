package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;

import java.util.UUID;

public interface EcmRegistrationService {

    UUID registerNewMemberByVddNumber(User user, int vddNumber);

    UUID registerNewMember(User user, UserDto personalData);
}
