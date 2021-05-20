package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.message.MessageUtils;
import de.fourtyseveneleven.ones.message.service.EmailService;
import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;
import de.fourtyseveneleven.ones.user.service.ForgotPasswordMessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

@Service
public class EmailForgotPasswordMessageService implements ForgotPasswordMessageService {

    private final MessageSource emailMessageSource;
    private final TemplateEngine templateEngine;
    private final EmailService emailService;

    public EmailForgotPasswordMessageService(@Qualifier("email") MessageSource emailMessageSource,
                                             @Qualifier("email") TemplateEngine templateEngine,
                                             EmailService emailService) {

        this.emailMessageSource = emailMessageSource;
        this.templateEngine = templateEngine;
        this.emailService = emailService;
    }

    @Override
    public void sendForgotPasswordMessage(ForgotPasswordRequest forgotPasswordRequest) {

        final Locale locale = MessageUtils.getLocale();

        final String recipientEmailAddress = forgotPasswordRequest.getUser().getEmailAddress();
        final String subject = getSubject(locale);

        final String plainTextMessage = buildPlainTextMessage(forgotPasswordRequest, locale);
        final String htmlMessage = buildHtmlMessage(forgotPasswordRequest, locale);

        emailService.sendEmail(recipientEmailAddress, subject, plainTextMessage, htmlMessage);
    }

    private String getSubject(Locale locale) {

        return getMessage("forgot-password.subject", locale);
    }

    private String buildPlainTextMessage(ForgotPasswordRequest forgotPasswordRequest,
                                         Locale locale) {

        return getMessage("forgot-password.plain-text", locale, buildResetUri(forgotPasswordRequest));
    }

    private String getMessage(String key, Locale locale, String... arguments) {

        return emailMessageSource.getMessage(key, arguments, locale);
    }

    private String buildHtmlMessage(ForgotPasswordRequest forgotPasswordRequest, Locale locale) {

        final Context context =  new Context(locale);
        context.setVariable("resetUri", buildResetUri(forgotPasswordRequest));
        context.setLocale(locale);

        return templateEngine.process("mail/forgot-password", context);
    }

    private String buildResetUri(ForgotPasswordRequest forgotPasswordRequest) {

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("reset-password")
                .queryParam("code", forgotPasswordRequest.getConfirmationCode())
                .toUriString();
    }
}
