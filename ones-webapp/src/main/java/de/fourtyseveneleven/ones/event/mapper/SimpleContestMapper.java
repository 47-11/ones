package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationHorsePlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationPlain;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

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
    default List<SimpleHorseDto> registrationsToHorseDtos(Set<EventContestCompetitionRegistrationPlain> eventContestCompetitionRegistrations) {

        if (isNull(eventContestCompetitionRegistrations)) {
            return emptyList();
        }

        return eventContestCompetitionRegistrations.stream()
                .map(EventContestCompetitionRegistrationPlain::getHorses)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(this::eventContestCompetitionRegistrationHorsePlainToSimpleHorseDto)
                .distinct()
                .collect(toList());
    }

    @Mapping(source = "horseUuid", target = "uuid")
    @Mapping(source = "displayHorse", target = "name")
    SimpleHorseDto eventContestCompetitionRegistrationHorsePlainToSimpleHorseDto(EventContestCompetitionRegistrationHorsePlain eventContestCompetitionRegistrationHorsePlain);
}
