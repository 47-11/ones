package de.fourtyseveneleven.ones.configuration.message;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class ExceptionMessageConfiguration extends AbstractMessageConfiguration{

    @Bean
    @Qualifier("exception")
    public static MessageSource exceptionMessageSource() {

        final ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages/exceptions");
        messageSource.setDefaultLocale(DEFAULT_LOCALE);
        messageSource.setDefaultEncoding(UTF_8.name());
        return messageSource;
    }
}
