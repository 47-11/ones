package de.fourtyseveneleven.ones.common.mapper;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper
public interface BaseMapper {

    default LocalDateTime mapOffsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {

        return LocalDateTime.from(offsetDateTime);
    }
}
