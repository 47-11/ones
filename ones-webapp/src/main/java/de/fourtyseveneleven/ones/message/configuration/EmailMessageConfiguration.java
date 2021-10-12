package de.fourtyseveneleven.ones.message.configuration;

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
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isBlank;

@Configuration
public class EmailMessageConfiguration extends AbstractMessageConfiguration {

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

        if (nonNull(emailSettings.getPort())) {
            mailSender.setPort(emailSettings.getPort());
        }

        mailSender.setProtocol("smtp");
        mailSender.setDefaultEncoding(UTF_8.name());

        final Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");

        properties.put("mail.smtp.starttls.enable", "true");

        final String username = emailSettings.getUsername();
        final String password = emailSettings.getPassword();
        if (isBlank(username) && isBlank(password)) {
            properties.put("mail.smtp.auth", "false");
        } else {
            mailSender.setUsername(username);
            mailSender.setPassword(password);
            properties.put("mail.smtp.auth", "true");
        }

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
