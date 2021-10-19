package de.fourtyseveneleven.ones.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    default <T> List<T> singletonListMapper(T singleElement) {

        if (isNull(singleElement)) {
            return Collections.emptyList();
        } else {
            return Collections.singletonList(singleElement);
        }
    }

    @Named("size")
    default int collectionSize(Collection<?> collection) {

        return collection.size();
    }

    @Named("defaultZero")
    default BigDecimal defaultZeroBigDecimalMapper(BigDecimal value) {

        if (isNull(value)) {
            return BigDecimal.ZERO;
        } else {
            return value;
        }
    }

    default UUID map(String asText) {

        if (isBlank(asText)) {
            return null;
        } else {
            return UUID.fromString(asText);
        }
    }

    default LocalDate map(OffsetDateTime offsetDateTime) {

        return LocalDate.from(offsetDateTime);
    }
}