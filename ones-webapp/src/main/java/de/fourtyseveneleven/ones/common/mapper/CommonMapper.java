package de.fourtyseveneleven.ones.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    default <T> List<T> setToList(Set<T> set) {

        return new ArrayList<>(set);
    }

    default <T> List<T> singletonListMapper(T singleElement) {

        if (isNull(singleElement)) {
            return Collections.emptyList();
        } else {
            return Collections.singletonList(singleElement);
        }
    }

    @Named("defaultZero")
    default BigDecimal defaultZeroBigDecimalMapper(BigDecimal value) {
        if (isNull(value)) {
            return BigDecimal.ZERO;
        } else {
            return value;
        }
    }
}