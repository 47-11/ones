package de.fourtyseveneleven.ones.service;

public interface EmailService {

    void sendEmail(String recipient, String subject, String plainTextMessage, String htmlMessage);
}
