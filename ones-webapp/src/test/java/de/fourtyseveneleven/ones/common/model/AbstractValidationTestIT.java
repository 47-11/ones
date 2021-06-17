package de.fourtyseveneleven.ones.common.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.TransactionSystemException;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.beans.BeanUtils.copyProperties;

public abstract class AbstractValidationTestIT<T extends BaseEntity> {

    protected abstract T buildValidEntity();

    protected abstract JpaRepository<T, Long> getRepository();

    @Test
    @Transactional
    void testValid() {

        final T validEntity = buildValidEntity();
        assertValidationSucceeds(validEntity);
    }

    protected void assertValidationSucceeds(T entity) {

        // Copy data to a new instance first to make sure the given entity is not dirtied.
        final var entityToSave = buildValidEntity();
        copyProperties(entity, entityToSave);

        assertThatNoException()
                .isThrownBy(() -> getRepository().save(entityToSave));
    }

    protected void assertValidationFailsWithMessages(T entity, String... expectedMessages) {

        // Copy data to a new instance first to make sure the given entity is not dirtied.
        final var entityToSave = buildValidEntity();
        copyProperties(entity, entityToSave);

        try {
            getRepository().save(entityToSave);
            final String failMessage = format("Expected validation fo fail.");
            fail(failMessage);
        } catch (TransactionSystemException e) {
            final Throwable rootCause = e.getRootCause();
            if (rootCause instanceof ConstraintViolationException constraintViolationException) {
                final List<String> actualMessages = constraintViolationException.getConstraintViolations()
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.toList());

                assertThat(actualMessages).containsExactlyInAnyOrder(expectedMessages);
            } else {
                final String failMessage = format("Expected root cause of exception to be instance of {0} but was {1}", ConstraintViolationException.class, rootCause.getClass());
                fail(failMessage);
            }
        }
    }

    @BeforeEach
    protected void setUp() {
        getRepository().deleteAll();
        LocaleContextHolder.setLocale(Locale.ENGLISH);
    }

    @AfterEach
    protected void tearDown() {
        getRepository().deleteAll();
    }
}
