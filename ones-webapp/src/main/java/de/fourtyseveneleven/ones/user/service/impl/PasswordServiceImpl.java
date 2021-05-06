package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.user.service.PasswordService;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO
    }

    @Override
    public void forgotPassword(String emailAddress) {
        // TODO
    }

    @Override
    public void forgotPasswordSetNewPassword(String confirmationCode, String newPassword) {
        // TODO
    }
}
