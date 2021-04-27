package de.fourtyseveneleven.ones.configuration.message;

import de.fourtyseveneleven.ones.settings.OnesSettings;
import de.fourtyseveneleven.ones.settings.message.EmailSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.messageresolver.SpringMessageResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Configuration
public class EmailMessageSourceConfiguration extends AbstractMessageConfiguration {

    @Bean
    @Qualifier("email")
    public MessageSource emailMessageSource() {

        final ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/email");
        messageSource.setDefaultLocale(DEFAULT_LOCALE);
        messageSource.setDefaultEncoding(UTF_8.name());
        return messageSource;
    }

    @Bean
    public JavaMailSender javaMailSender(OnesSettings onesSettings) {

        return javaMailSender(onesSettings.getMessage().getEmail());
    }

    private JavaMailSender javaMailSender(EmailSettings emailSettings) {

        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(emailSettings.getHost());
        mailSender.setUsername(emailSettings.getUsername());
        mailSender.setPassword(emailSettings.getPassword());

        if (nonNull(emailSettings.getPort())) {
            mailSender.setPort(emailSettings.getPort());
        }

        mailSender.setProtocol("smtp");
        mailSender.setDefaultEncoding(UTF_8.name());

        final Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }

    @Bean
    @Qualifier("email")
    public TemplateEngine emailTemplateEngine(@Qualifier("email") MessageSource messageSource, ITemplateResolver templateResolver) {

        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateEngineMessageSource(messageSource);
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
}
