package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.message.service.EmailService;
import de.fourtyseveneleven.ones.user.model.UserRegistration;
import de.fourtyseveneleven.ones.user.service.RegistrationConfirmationMessageService;
import de.fourtyseveneleven.ones.message.MessageUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

@Service
public class EmailRegistrationConfirmationMessageService implements RegistrationConfirmationMessageService {

    private final MessageSource emailMessageSource;
    private final TemplateEngine templateEngine;
    private final EmailService emailService;

    public EmailRegistrationConfirmationMessageService(@Qualifier("email") MessageSource emailMessageSource, @Qualifier("email") TemplateEngine templateEngine, EmailService emailService) {
        this.emailMessageSource = emailMessageSource;
        this.templateEngine = templateEngine;
        this.emailService = emailService;
    }

    @Override
    public void sendRegistrationConfirmationMessage(UserRegistration registration) {

        final Locale locale = MessageUtils.getLocale();

        final String recipientEmailAddress = registration.getEmailAddress();
        final String subject = getSubject(locale);

        final String plainTextMessage = buildPlainTextMessage(registration, locale);
        final String htmlMessage = buildHtmlMessage(registration, locale);

        emailService.sendEmail(recipientEmailAddress, subject, plainTextMessage, htmlMessage);
    }

    private String getSubject(Locale locale) {

        return getMessage("registration.confirmation.subject", locale);
    }

    private String buildPlainTextMessage(UserRegistration registration, Locale locale) {

        return getMessage("registration.confirmation.plain-text", locale, buildConfirmationUri(registration));
    }

    private String getMessage(String key, Locale locale, String... arguments) {

        return emailMessageSource.getMessage(key, arguments, locale);
    }

    private String buildHtmlMessage(UserRegistration registration, Locale locale) {

        final Context context =  new Context(locale);
        context.setVariable("confirmationUri", buildConfirmationUri(registration));
        context.setLocale(locale);

        return templateEngine.process("mail/registration-confirmation", context);
    }

    private String buildConfirmationUri(UserRegistration registration) {

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("verified")
                .queryParam("code", registration.getConfirmationCode())
                .toUriString();
    }
}
