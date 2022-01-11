package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationHorsePlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorsePlain;
import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toSet;

@Mapper(componentModel = "spring",
        uses = {
                CommonMapper.class,
                DateTimeFormatMapper.class
        })
public interface SimpleContestMapper {

    @Mapping(source = "raiseLength", target = "distance")
    @Mapping(source = "registrations", target = "signedUpHorses", qualifiedByName = "registrationsToHorseDtos")
    SimpleContestDto fromEcmDto(EventContestCompetitionPlain eventContestCompetition);

    @Named("registrationsToHorseDtos")
    default Set<SimpleHorseDto> registrationsToHorseDtos(Set<EventContestCompetitionRegistrationPlain> eventContestCompetitionRegistrations) {

        if (isNull(eventContestCompetitionRegistrations)) {
            return Collections.emptySet();
        }

        return eventContestCompetitionRegistrations.stream()
                .map(EventContestCompetitionRegistrationPlain::getHorses)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(EventContestCompetitionRegistrationHorsePlain::getHorse)
                .map(this::masterdataHorsePlainToSimpleHorseDto)
                .collect(toSet());
    }

    SimpleHorseDto masterdataHorsePlainToSimpleHorseDto(MasterdataHorsePlain masterdataHorse);
}
