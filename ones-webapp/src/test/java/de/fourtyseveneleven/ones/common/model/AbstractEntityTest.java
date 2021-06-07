package de.fourtyseveneleven.ones.common.model;

import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractEntityTest<T extends AbstractBaseEntity> {

    private final T first = buildEntity(1L);
    private final T second = buildEntity(1L);
    private final T third = buildEntity(1L);
    private final T fourth = buildEntity(410L);
    private final TestEntity other = new TestEntity(1L);

    protected abstract T buildEntity();

    private T buildEntity(long id) {

        final T entity = buildEntity();
        entity.setId(id);
        return entity;
    }

    @Test
    void testEqualityOfTestEntities() {

        assertThat(first.equals(second)).isTrue();
        assertThat(first.equals(third)).isTrue();
        assertThat(first.equals(fourth)).isFalse();
        assertThat(first.equals(other)).isFalse();
        assertThat(second.equals(third)).isTrue();
        assertThat(second.equals(fourth)).isFalse();
        assertThat(second.equals(other)).isFalse();
        assertThat(third.equals(fourth)).isFalse();
        assertThat(third.equals(other)).isFalse();
        assertThat(fourth.equals(other)).isFalse();
    }

    @Test
    void testEqualsIsReflective() {

        testEqualsIsReflective(first);
        testEqualsIsReflective(second);
        testEqualsIsReflective(third);
        testEqualsIsReflective(fourth);
        testEqualsIsReflective(other);
    }

    private void testEqualsIsReflective(AbstractBaseEntity entity) {

        assertThat(entity.equals(entity)).isTrue();
    }

    @Test
    void testEqualsIsSymmetric() {

        testEqualsIsSymmetric(first, second);
        testEqualsIsSymmetric(first, third);
        testEqualsIsSymmetric(first, fourth);
        testEqualsIsSymmetric(first, other);
        testEqualsIsSymmetric(second, third);
        testEqualsIsSymmetric(second, fourth);
        testEqualsIsSymmetric(second, other);
        testEqualsIsSymmetric(third, fourth);
        testEqualsIsSymmetric(third, other);
        testEqualsIsSymmetric(fourth, other);
    }

    private void testEqualsIsSymmetric(AbstractBaseEntity a, AbstractBaseEntity b) {

        assertThat(a.equals(b)).isEqualTo(b.equals(a));
    }

    @Test
    void testEqualsIsTransitive() {

        final boolean firstIsEqualToSecond = first.equals(second);
        final boolean firstIsEqualToThird = first.equals(third);
        final boolean secondIsEqualToThird = second.equals(third);

        assertThat(firstIsEqualToSecond).isTrue();
        assertThat(firstIsEqualToThird).isTrue();
        assertThat(secondIsEqualToThird).isTrue();
    }

    @Test
    void testEqualsIsConsistent() {

        testEqualsIsConsistent(first, second);
        testEqualsIsConsistent(first, third);
        testEqualsIsConsistent(first, fourth);
        testEqualsIsConsistent(first, other);
        testEqualsIsConsistent(second, third);
        testEqualsIsConsistent(second, fourth);
        testEqualsIsConsistent(second, other);
        testEqualsIsConsistent(third, fourth);
        testEqualsIsConsistent(third, other);
        testEqualsIsConsistent(fourth, other);
    }

    void testEqualsIsConsistent(AbstractBaseEntity a, AbstractBaseEntity b) {

        final boolean expected = a.equals(b);
        for (int i = 0; i < 100; i++) {

            final boolean actual = a.equals(b);
            assertThat(actual).withFailMessage(() ->
                    MessageFormat.format(
                            "equals() for values {0} and {1} is not consistent. Got result {2} but previous result was {3}",
                            a, b, actual, expected))
                    .isEqualTo(expected);
        }
    }

    @Test
    void testEqualsWithNullValue() {

        testEqualsWithNullValue(first);
        testEqualsWithNullValue(second);
        testEqualsWithNullValue(third);
        testEqualsWithNullValue(fourth);
        testEqualsWithNullValue(other);
    }

    private void testEqualsWithNullValue(AbstractBaseEntity entity) {

        assertThat(entity.equals(null)).isFalse();
    }

    @Test
    void testHashCodeIsConsistent() {

        testHashCodeIsConsistent(first);
        testHashCodeIsConsistent(second);
        testHashCodeIsConsistent(third);
        testHashCodeIsConsistent(fourth);
        testHashCodeIsConsistent(other);
    }

    private void testHashCodeIsConsistent(AbstractBaseEntity entity) {

        final int expected = entity.hashCode();
        for (int i = 0; i < 100; i++) {

            final int actual = entity.hashCode();
            assertThat(actual).withFailMessage(() ->
                    MessageFormat.format(
                            "hashCode() for value {0} is not consistent. Got result {1} but previous result was {2}",
                            entity, actual, expected))
                    .isEqualTo(expected);
        }
    }

    @Test
    void testEqualObjectsProduceTheSameHashCode() {

        assertThat(first.hashCode()).isEqualTo(second.hashCode());
        assertThat(first.hashCode()).isEqualTo(third.hashCode());
    }

    private static class TestEntity extends AbstractBaseEntity {

        @Serial
        private static final long serialVersionUID = 738038948274571602L;

        private TestEntity(long id) {

            setId(id);
        }

        @Override
        protected boolean canEqual(Object other) {
            return other instanceof TestEntity;
        }

        @Override
        public long getId() {
            return doGetId();
        }
    }
}

