package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.dto.EmailPasswordDto;

public interface RegistrationService {

    void createRegistration(EmailPasswordDto emailPasswordDto);

    void confirmRegistration(String registrationConfirmationCode);
}
