package de.fourtyseveneleven.ones.user.service;

public interface PasswordService {

    void changePassword(String oldPassword, String newPassword);

    void forgotPassword(String emailAddress);

    void forgotPasswordSetNewPassword(String confirmationCode, String newPassword);
}
