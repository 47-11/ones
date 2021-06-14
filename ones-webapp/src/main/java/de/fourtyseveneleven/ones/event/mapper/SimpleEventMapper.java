package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = DateTimeFormatMapper.class
)
public interface SimpleEventMapper {

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locationDesciption", target = "address.locationName")
    @Mapping(source = "countryRegion", target = "address.region")
    @Mapping(source = "country", target = "address.country")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    SimpleEventDto eventContestPlainToSimpleEventDto(EventContestPlain eventContestPlain);

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locationDesciption", target = "address.locationName")
    @Mapping(source = "countryRegion", target = "address.region")
    @Mapping(source = "country", target = "address.country")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    SimpleEventDto eventContestToSimpleEventDto(EventContest eventContest);
}
