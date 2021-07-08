package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRemark;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                CommonMapper.class,
                EventAddressMapper.class
        }
)
public abstract class FullEventMapper {

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locations", target = "addresses")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    @Mapping(source = "registrationClosing", target = "signupDeadline")
    @Mapping(source = "infoVaccinationObligation", target = "isVaccinationMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "infoHelmetObligation", target = "isHelmetMandatory", qualifiedByName = "obligationInfoToBoolean")
    @Mapping(source = "remarks", target = "additionalComments")
    @Mapping(source = "countryRegion", target = "region")
    public abstract FullEventDto eventContestToFullEventDto(EventContest eventContest);

    @Named(value = "obligationInfoToBoolean")
    protected boolean obligationInfoToBoolean(String obligationInfo) {

        return isNotBlank(obligationInfo);
    }

    protected List<String> remarksToAdditionalComments(Set<EventContestRemark> remarks) {

        return remarks.stream()
                .map(EventContestRemark::getDescription)
                .toList();
    }
}

