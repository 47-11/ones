package de.fourtyseveneleven.ones.results.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResult;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResultHorse;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public abstract class ResultMapper {


    @Mapping(source = "timeRace", target = "duration")
    @Mapping(source = "kmH", target = "averageSpeed")
    @Mapping(source = "tempo", target = "pace")
    @Mapping(source = "failureReasonRemark", target = "failureReason")
    // TODO: Map event and contest
    public abstract ResultDto fromEcmDto(EventContestCompetitionResult eventContestCompetitionResult);

    protected Long timeTotalToDuration(OffsetDateTime timeTotal) {

        if (isNull(timeTotal)) {
            return null;
        }

        final LocalDateTime startOfDay = timeTotal.toLocalDate().atStartOfDay();
        return startOfDay.until(timeTotal, ChronoUnit.MILLIS);
    }

    protected SimpleHorseDto mapHorseDto(EventContestCompetitionResultHorse ecmHorse) {

        if (isNull(ecmHorse)) {
            return null;
        }

        return new SimpleHorseDto(UUID.fromString(ecmHorse.getUuid()), null);
    }
}
