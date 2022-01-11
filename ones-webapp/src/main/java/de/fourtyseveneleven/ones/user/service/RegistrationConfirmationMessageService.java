package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.UserRegistration;

public interface RegistrationConfirmationMessageService {

    void sendRegistrationConfirmationMessage(UserRegistration registration);
}
