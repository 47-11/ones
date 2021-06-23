package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.common.mapper.PersonDtoMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                PersonDtoMapper.class,
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
    @Mapping(source = "registrationClosing", target = "signupDeadline")
    @Mapping(source = "lateRegistrationFee", target = "signupDeadlineMissedFee", qualifiedByName = "defaultZero")
    @Mapping(source = "infoVaccinationObligation", target = "isVaccinationMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "infoHelmetObligation", target = "isHelmetMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "remarks", target = "additionalComments", qualifiedByName = "remarksToAdditionalComments")
    public abstract FullEventDto eventContestToFullEventDto(EventContest eventContest);

    @Named(value = "obligationInfoToBoolean")
    protected boolean obligationInfoToBoolean(String obligationInfo) {

        return isNotBlank(obligationInfo);
    }

    @Named("remarksToAdditionalComments")
    protected List<String> remarksToAdditionalComments(String remarks) {

        if (isBlank(remarks)) {
            return emptyList();
        } else {
            return Arrays.asList(remarks.split("[\\r\\n]+"));
        }
    }
}

