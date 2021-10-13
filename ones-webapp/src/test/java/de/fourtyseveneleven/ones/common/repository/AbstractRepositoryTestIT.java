package de.fourtyseveneleven.ones.common.repository;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;
import de.fourtyseveneleven.ones.common.model.BaseEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public abstract class AbstractRepositoryTestIT<T extends AbstractBaseEntity> {

    private static final int NUMBER_OF_TEST_ENTITIES = 10;

    protected abstract JpaRepository<T, Long> getRepository();

    protected abstract T getTestEntity();

    @BeforeEach
    void setup() {

        for (int i = 0; i < NUMBER_OF_TEST_ENTITIES; i++) {
            getRepository().save(getTestEntity());
        }
    }

    @AfterEach
    void tearDown() {

        getRepository().deleteAll();
    }

    @Test
    void testGetOne() {

        final long testId = getRepository().findAll().get(0).getId();

        final T entity = getRepository().getOne(testId);
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(testId);
    }

    @Test
    void testFindById() {

        final long testId = getRepository().findAll().get(1).getId();

        final Optional<T> entity = getRepository().findById(testId);
        assertThat(entity).isPresent();
        assertThat(entity.get().getId()).isEqualTo(testId);

        assertThat(getRepository().findById(12345678L)).isEmpty();
    }

    @Test
    void testFindAll() {

        final List<T> foundEntities = getRepository().findAll()
                .stream()
                .distinct()
                .toList();
        assertThat(foundEntities).hasSize(NUMBER_OF_TEST_ENTITIES);
    }

    @Test
    void testFindAllById() {

        final List<Long> testIds = getRepository().findAll()
                .stream()
                .skip(2)
                .limit(2)
                .map(BaseEntity::getId)
                .toList();

        final List<T> foundEntities = getRepository().findAllById(testIds);
        final List<Long> idsOfFoundEntities = foundEntities.stream().map(T::getId).collect(toList());

        assertThat(idsOfFoundEntities).containsExactlyElementsOf(testIds);
    }

    @Test
    void testSave() {

        final long highestId = getRepository().findAll()
                .stream()
                .map(BaseEntity::getId)
                .max(Comparator.naturalOrder())
                .orElseThrow();
        final long expectedId = highestId + 1;

        final T entity = getTestEntity();

        final T savedEntity = getRepository().save(entity);
        assertThat(savedEntity).isNotNull();

        final Long idOfSavedEntity = savedEntity.getId();
        assertThat(idOfSavedEntity).isEqualTo(expectedId);
    }

    @Test
    void testDelete() {

        final List<T> allEntities = getRepository().findAll();
        final long testId = allEntities.get(4).getId();

        final T toDelete = getRepository().getOne(testId);
        getRepository().delete(toDelete);

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        final List<Long> idsOfEntitiesAfterDeletion = entitiesAfterDeletion.stream().map(T::getId).distinct().collect(toList());

        final List<Long> expectedIdsAfterDeletion = allEntities.stream()
                .map(BaseEntity::getId)
                .filter(id -> id != testId)
                .toList();

        assertThat(idsOfEntitiesAfterDeletion).containsExactlyElementsOf(expectedIdsAfterDeletion);
    }

    @Test
    void testDeleteInBatch() {

        final List<T> entitiesBeforeDeletion = getRepository().findAll();
        getRepository().deleteInBatch(entitiesBeforeDeletion);

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        assertThat(entitiesAfterDeletion).isEmpty();
    }

    @Test
    void testDeleteAllInList() {

        final List<T> entitiesBeforeDeletion = getRepository().findAll();
        getRepository().deleteAll(entitiesBeforeDeletion);

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        assertThat(entitiesAfterDeletion).isEmpty();
    }

    @Test
    void testDeleteAll() {

        getRepository().deleteAll();

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        assertThat(entitiesAfterDeletion).isEmpty();
    }

    @Test
    void testDeleteAllInBatch() {

        getRepository().deleteAllInBatch();

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        assertThat(entitiesAfterDeletion).isEmpty();
    }
}
