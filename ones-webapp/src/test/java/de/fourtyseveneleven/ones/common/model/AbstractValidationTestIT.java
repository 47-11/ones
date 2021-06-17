package de.fourtyseveneleven.ones.common.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.TransactionSystemException;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
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

    protected void assertValidationFails(T entity) {

        // Copy data to a new instance first to make sure the given entity is not dirtied.
        final var entityToSave = buildValidEntity();
        copyProperties(entity, entityToSave);

        assertThatExceptionOfType(TransactionSystemException.class)
                .isThrownBy(() -> getRepository().save(entityToSave))
                .withRootCauseInstanceOf(ConstraintViolationException.class);
    }

    @BeforeEach
        protected void setUp() {
        getRepository().deleteAll();
    }

    @AfterEach
    protected void tearDown() {
        getRepository().deleteAll();
    }
}
