package de.fourtyseveneleven.ones.message.service.impl;

import de.fourtyseveneleven.ones.message.service.EmailService;
import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.message.EmailSettings;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final String senderMailAddress;
    private final String overrideRecipientMailAddress;

    public EmailServiceImpl(JavaMailSender javaMailSender, OnesSettings onesSettings) {
        this.javaMailSender = javaMailSender;

        final EmailSettings emailSettings = onesSettings.getMessage().getEmail();
        this.senderMailAddress = emailSettings.getSenderAddress();
        this.overrideRecipientMailAddress = emailSettings.getOverrideRecipientAddress();
    }

    @Override
    public void sendEmail(String recipient, String subject, String plainTextMessage, String htmlMessage) {

        final MimeMessagePreparator mimeMessagePreparator = buildMimeMessagePreparator(recipient, subject, plainTextMessage, htmlMessage);
        javaMailSender.send(mimeMessagePreparator);
    }

    private MimeMessagePreparator buildMimeMessagePreparator(String recipient, String subject, String plainTextMessage, String htmlMessage) {

        return mimeMessage -> {
            final MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(senderMailAddress);
            mimeMessageHelper.setTo(getRecipient(recipient));
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(plainTextMessage, htmlMessage);
        };
    }

    private String getRecipient(String recipient) {

        if (isBlank(overrideRecipientMailAddress)) {
            return recipient;
        } else {
            return overrideRecipientMailAddress;
        }
    }
}
