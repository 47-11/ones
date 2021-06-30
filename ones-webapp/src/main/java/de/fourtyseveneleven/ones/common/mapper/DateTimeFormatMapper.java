package de.fourtyseveneleven.ones.common.mapper;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public interface DateTimeFormatMapper {

    default LocalDateTime mapOffsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {

        if (isNull(offsetDateTime)) {
            return null;
        } else {
            return LocalDateTime.from(offsetDateTime);
        }
    }
}
