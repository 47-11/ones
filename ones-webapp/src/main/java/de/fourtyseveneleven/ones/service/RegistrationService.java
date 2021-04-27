package de.fourtyseveneleven.ones.service;

import de.fourtyseveneleven.ones.model.dto.RegistrationDto;

public interface RegistrationService {

    void createRegistration(RegistrationDto registrationDto);

    void confirmRegistration(String registrationConfirmationCode);
}
