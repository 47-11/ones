package de.fourtyseveneleven.ones.common.repository;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public abstract class AbstractRepositoryTestIT<T extends AbstractBaseEntity> {

    private static final List<Long> TEST_ENTITY_IDS;
    static {
        final Long[] ids = {1L, 4711L, Long.MAX_VALUE};
        TEST_ENTITY_IDS = Arrays.asList(ids);
    }

    protected abstract JpaRepository<T, Long> getRepository();

    protected abstract T getTestEntity();

    @BeforeEach
    void setup() {

        getRepository().saveAll(getTestEntities());
    }

    private T getTestEntity(long id) {

        final T testEntity = getTestEntity();
        testEntity.setId(id);
        return testEntity;
    }

    @AfterEach
    void tearDown() {

        getRepository().deleteAll();
    }

    private List<T> getTestEntities() {

        return TEST_ENTITY_IDS.stream().map(this::getTestEntity).collect(Collectors.toList());
    }

    @Test
    void testGetOne() {

        final Long testId = TEST_ENTITY_IDS.get(0);

        final T entity = getRepository().getOne(testId);
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(testId);
    }

    @Test
    void testFindById() {

        final Long testId = TEST_ENTITY_IDS.get(0);

        final Optional<T> entity = getRepository().findById(testId);
        assertThat(entity).isPresent();
        assertThat(entity.get().getId()).isEqualTo(testId);

        assertThat(getRepository().findById(1234L)).isEmpty();
    }

    @Test
    void testFindAll() {

        final List<T> foundEntities = getRepository().findAll();
        final List<Long> idsOfFoundEntities = foundEntities.stream().map(T::getId).collect(Collectors.toList());

        assertThat(idsOfFoundEntities).containsExactlyElementsOf(TEST_ENTITY_IDS);
    }

    @Test
    void testFindAllById() {

        final List<Long> ids = TEST_ENTITY_IDS.subList(1, 3);

        final List<T> foundEntities = getRepository().findAllById(ids);
        final List<Long> idsOfFoundEntities = foundEntities.stream().map(T::getId).collect(Collectors.toList());

        assertThat(idsOfFoundEntities).containsExactlyElementsOf(ids);
    }

    @Test
    void testSave() {

        final T entity = getTestEntity(4);

        final T savedEntity = getRepository().save(entity);
        assertThat(savedEntity).isNotNull();

        final Long idOfSavedEntity = savedEntity.getId();
        assertThat(idOfSavedEntity).isEqualTo(4);
    }

    @Test
    void testDelete() {

        final T toDelete = getRepository().getOne(TEST_ENTITY_IDS.get(0));
        getRepository().delete(toDelete);

        final List<T> entitiesAfterDeletion = getRepository().findAll();
        final List<Long> idsOfEntitiesAfterDeletion = entitiesAfterDeletion.stream().map(T::getId).distinct().collect(Collectors.toList());

        final List<Long> expectedIdsAfterDeletion = TEST_ENTITY_IDS.subList(1, 3);
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
