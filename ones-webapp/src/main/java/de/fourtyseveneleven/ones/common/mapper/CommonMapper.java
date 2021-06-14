package de.fourtyseveneleven.ones.common.mapper;

import org.mapstruct.Mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public interface CommonMapper {

    default <T> List<T> singletonListMapper(T singleElement) {

        if (isNull(singleElement)) {
            return Collections.emptyList();
        } else {
            return Collections.singletonList(singleElement);
        }
    }
}