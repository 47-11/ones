package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;

public interface RegistrationService {

    void createRegistration(RegistrationDto registrationDto);

    void confirmRegistration(String registrationConfirmationCode);
}
