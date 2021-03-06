package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.*;
import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring",
        uses = {
                CommonMapper.class,
                DateTimeFormatMapper.class
        })
public interface FullContestMapper {

    @Mapping(source = "kind", target = "category")
    @Mapping(source = "raiseLength", target = "distance")
    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "vddQualificationLevel", target = "qualificationLevel")
    @Mapping(source = "isCARD", target = "isMap")
    @Mapping(source = "stages", target = "numberOfStages", qualifiedByName = "size")
    @Mapping(source = "horseAgeMin", target = "minimumHorseAge")
    @Mapping(source = "horseAgeMax", target = "maximumHorseAge")
    @Mapping(source = "contestantAgeMin", target = "minimumParticipantAge")
    @Mapping(source = "contestantAgeMax", target = "maximumParticipantAge")
    @Mapping(source = "contestantQuantityMin", target = "minimumParticipants")
    @Mapping(source = "contestantQuantityMax", target = "maximumParticipants")
    @Mapping(source = "isMARKED", target = "markings")
    @Mapping(source = "registrationFee", target = "signupFee")
    @Mapping(source = "startingFee", target = "startFee")
    @Mapping(source = "registrations", target = "signedUpHorses", qualifiedByName = "registrationsToHorseDtos")
    FullContestDto fromEcmDto(EventContestCompetitionPlain eventContestCompetition);

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
