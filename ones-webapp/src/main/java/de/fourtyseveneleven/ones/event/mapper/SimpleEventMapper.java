package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.AddressDtoMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                CommonMapper.class,
                AddressDtoMapper.class,
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
}
