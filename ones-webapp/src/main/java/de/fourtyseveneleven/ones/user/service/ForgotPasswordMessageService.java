package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;

public interface ForgotPasswordMessageService {

    void sendForgotPasswordMessage(ForgotPasswordRequest forgotPasswordRequest);
}
