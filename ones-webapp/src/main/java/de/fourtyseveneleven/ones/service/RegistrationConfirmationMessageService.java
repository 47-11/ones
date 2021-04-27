package de.fourtyseveneleven.ones.service;

import de.fourtyseveneleven.ones.model.User;

public interface RegistrationConfirmationMessageService {

    void sendRegistrationConfirmationMessage(User user);
}
