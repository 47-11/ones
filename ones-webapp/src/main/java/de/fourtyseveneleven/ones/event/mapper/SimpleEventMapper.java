package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.AddressMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.*;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import org.mapstruct.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                CommonMapper.class,
                AddressMapper.class,
                EventStatusMapper.class
        }
)
public interface SimpleEventMapper {

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locations", target = "addresses")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    @Mapping(source = "countryRegion", target = "region")
    @Mapping(source = "state", target = "status")
    SimpleEventDto eventContestPlainToSimpleEventDto(EventContestPlain eventContest);

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locations", target = "addresses")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    @Mapping(source = "countryRegion", target = "region")
    @Mapping(source = "state", target = "status")
    SimpleEventDto eventContestToSimpleEventDto(EventContest eventContest);

    @AfterMapping
    default void eventContestToSimpleEventDto(EventContest eventContest, @MappingTarget SimpleEventDto simpleEventDto) {

        final Set<EventContestCompetition> competitions = Optional.ofNullable(eventContest.getCompetitions())
                .orElseGet(Collections::emptySet);
        final Set<SimpleHorseDto> signedUpHorses = competitions.stream()
                .map(EventContestCompetition::getRegistrations)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(EventContestCompetitionRegistration::getHorses)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(EventContestCompetitionRegistrationHorse::getHorse)
                .map(this::masterdataHorseToSimpleHorseDto)
                .collect(Collectors.toSet());

        simpleEventDto.setSignedUpHorses(signedUpHorses);
    }

    SimpleHorseDto masterdataHorseToSimpleHorseDto(MasterdataHorse masterdataHorse);
}
