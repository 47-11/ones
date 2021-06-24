package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.ContactMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                ContactMapper.class,
                CommonMapper.class
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
    @Mapping(source = "organizerContactUuid", target = "eventOrganizer", qualifiedByName = "contactUuidToPersonDto")
    @Mapping(source = "organizerContactUuid", target = "contactPerson", qualifiedByName = "contactUuidToPersonDto")
    // TODO: Replace with correct source field
    @Mapping(source = "beginning", target = "signupDeadline")
    @Mapping(source = "lateRegistrationFee", target = "signupDeadlineMissedFee", qualifiedByName = "defaultZero")
    @Mapping(source = "infoVaccinationObligation", target = "isVaccinationMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "infoHelmetObligation", target = "isHelmetMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "remarks", target = "additionalComments")
    public abstract FullEventDto eventContestToFullEventDto(EventContest eventContest);

    @Named(value = "obligationInfoToBoolean")
    public boolean obligationInfoToBoolean(String obligationInfo) {

        return isNotBlank(obligationInfo);
    }
}

