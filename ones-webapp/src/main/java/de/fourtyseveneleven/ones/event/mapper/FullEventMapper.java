package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.ContactMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                ContactMapper.class
        }
)
public abstract class FullEventMapper {

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locationDesciption", target = "address.locationName")
    @Mapping(source = "countryRegion", target = "address.region")
    @Mapping(source = "country", target = "address.country")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    @Mapping(source = "promoterContactUuid", target = "eventHost", qualifiedByName = "contactUuidToPersonDto")
    @Mapping(source = "lateRegistrationFee", target = "participationApplicationDeadlineMissedFee")
    // TODO: @Mapping(source = "isVaccinationMandatory", target = "???")
    // TODO: @Mapping(source = "isHelmetMandatory", target = "???")
    public abstract FullEventDto eventContestToFullEventDto(EventContest eventContest);
}

