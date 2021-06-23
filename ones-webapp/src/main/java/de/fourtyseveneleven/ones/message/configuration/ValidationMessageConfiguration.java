package de.fourtyseveneleven.ones.message.configuration;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;

import javax.validation.MessageInterpolator;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class ValidationMessageConfiguration extends AbstractMessageConfiguration {

    @Bean
    @Qualifier("validation")
    public MessageSource validationMessageSource() {

        final ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages/validation");
        messageSource.setDefaultLocale(DEFAULT_LOCALE);
        messageSource.setDefaultEncoding(UTF_8.name());
        return messageSource;
    }

    @Bean
    @Qualifier("validation")
    public ResourceBundleLocator validationResourceBundleLocator(
            @Qualifier("validation") MessageSource validationMessageSource) {

        return new MessageSourceResourceBundleLocator(validationMessageSource);
    }

    @Bean
    @Qualifier("validation")
    public MessageInterpolator validationMessageInterpolator(
            @Qualifier("validation") ResourceBundleLocator validationResourceBundleLocator) {

        return new ResourceBundleMessageInterpolator(
                validationResourceBundleLocator);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(
            @Qualifier("validation") MessageInterpolator validationMessageInterpolator) {

        final LocalValidatorFactoryBean localValidatorFactoryBean =
                new LocalValidatorFactoryBean();
        localValidatorFactoryBean
                .setMessageInterpolator(validationMessageInterpolator);
        return localValidatorFactoryBean;
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(
            LocalValidatorFactoryBean localValidatorFactoryBean) {

        return hibernateProperties -> hibernateProperties.put(
                "javax.persistence.validation.factory", localValidatorFactoryBean);
    }
}
