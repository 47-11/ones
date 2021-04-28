package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.User;

public interface RegistrationConfirmationMessageService {

    void sendRegistrationConfirmationMessage(User user);
}
