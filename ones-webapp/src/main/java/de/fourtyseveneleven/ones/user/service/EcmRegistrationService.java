package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.PersonalDataDto;

import java.util.UUID;

public interface EcmRegistrationService {

    UUID registerExistingMember(User user, int vddMemberNumber);

    UUID registerNewMember(User user, PersonalDataDto personalData);

}
