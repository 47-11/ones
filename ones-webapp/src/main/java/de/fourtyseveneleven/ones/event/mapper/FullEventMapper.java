package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestFee;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRemark;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRole;
import de.fourtyseveneleven.ones.event.model.dto.AccommodationDto;
import de.fourtyseveneleven.ones.event.model.dto.FeeDto;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring",
        uses = {
                DateTimeFormatMapper.class,
                CommonMapper.class,
                EventAddressMapper.class,
                EventStatusMapper.class
        }
)
public abstract class FullEventMapper {

    @Autowired
    protected AccommodationDtoMapper accommodationDtoMapper;

    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "ending", target = "end")
    @Mapping(source = "locations", target = "addresses")
    @Mapping(source = "isCountryChampionship", target = "isNationalChampionship")
    @Mapping(source = "isCei", target = "isInternational")
    @Mapping(source = "registrationClosing", target = "signupDeadline")
    @Mapping(source = "infoVaccinationObligation", target = "vaccinationInformation")
    @Mapping(source = "infoHelmetObligation", target = "helmetInformation")
    @Mapping(source = "remarks", target = "additionalComments")
    @Mapping(source = "countryRegion", target = "region")
    @Mapping(source = "roles", target = "eventHost", qualifiedByName = "eventHostFromRoles")
    @Mapping(source = "roles", target = "eventOrganizer", qualifiedByName = "eventOrganizerFromRoles")
    @Mapping(source = "roles", target = "contactPerson", qualifiedByName = "contactPersonFromRoles")
    @Mapping(source = "promoterEventUrl", target = "organizerWebsiteUrl")
    @Mapping(source = "promoterTenderingUrl", target = "signupDocumentUrl")
    @Mapping(source = "fees", target = "lateSignupFee", qualifiedByName = "lateSignupFee")
    @Mapping(source = "fees", target = "signupChangeFee", qualifiedByName = "signupChangeFee")
    @Mapping(source = "fees", target = "availableAccommodations")
    @Mapping(source = "contestantQuantityMin", target = "minimumParticipants")
    @Mapping(source = "contestantQuantityMax", target = "maximumParticipants")
    @Mapping(source = "state", target = "status")
    public abstract FullEventDto eventContestToFullEventDto(EventContest eventContest);

    protected List<String> remarksToAdditionalComments(Set<EventContestRemark> remarks) {

        return remarks.stream()
                .map(EventContestRemark::getDescription)
                .toList();
    }

    @Named("eventHostFromRoles")
    protected PersonDto eventHostFromRoles(Set<EventContestRole> roles) {

        return findPersonByRoleKind(roles, "PROMOTER");
    }

    @Named("eventOrganizerFromRoles")
    protected PersonDto eventOrganizerFromRoles(Set<EventContestRole> roles) {

        return findPersonByRoleKind(roles, "ORGANIZER");
    }

    @Named("contactPersonFromRoles")
    protected PersonDto contactPersonFromRoles(Set<EventContestRole> roles) {

        return findPersonByRoleKind(roles, "REGISTRATION");
    }

    private PersonDto findPersonByRoleKind(Set<EventContestRole> roles, String roleKind) {

        return roles.stream()
                .filter(role -> roleKind.equalsIgnoreCase(role.getKind()))
                .findFirst()
                .map(this::personDtoFromRole)
                .orElse(null);
    }

    private PersonDto personDtoFromRole(EventContestRole role) {

        final PersonDto personDto = new PersonDto();
        personDto.setName(formatName(role));

        personDto.setAddress(addressDtoFromRole(role));
        if (isNotBlank(role.getPhone())) {
            personDto.setPhoneNumber(role.getPhone());
        } else {
            personDto.setPhoneNumber(role.getCellPhone());
        }
        personDto.setEmailAddress(role.getEmail());

        return personDto;
    }

    private String formatName(EventContestRole role) {

        return String.format("%s %s %s", emptyIfNull(role.getName1()), emptyIfNull(role.getName2()),
                emptyIfNull(role.getName3())).trim();
    }

    private String emptyIfNull(String value) {

        if (isNull(value)) {
            return "";
        } else {
            return value;
        }
    }

    private AddressDto addressDtoFromRole(EventContestRole role) {

        final AddressDto addressDto = new AddressDto();
        addressDto.setStreet(role.getStreet());
        addressDto.setCity(role.getCity());
        addressDto.setZipCode(role.getZipcode());
        addressDto.setCountry(role.getCountry());

        return addressDto;
    }

    @Named("lateSignupFee")
    protected FeeDto lateSignupFee(Set<EventContestFee> fees) {

        return fees.stream()
                .filter(f -> "ADMINISTRATION".equalsIgnoreCase(f.getKind()))
                .filter(f -> "REGISTRATION_LATE".equalsIgnoreCase(f.getKey()))
                .map(this::feeDtoFromEventContestFee)
                .findFirst()
                .orElse(null);
    }

    @Named("signupChangeFee")
    protected FeeDto signupChangeFee(Set<EventContestFee> fees) {

        return fees.stream()
                .filter(f -> "ADMINISTRATION".equalsIgnoreCase(f.getKind()))
                .filter(f -> "REGISTRATION_CHANGE".equalsIgnoreCase(f.getKey()))
                .map(this::feeDtoFromEventContestFee)
                .findFirst()
                .orElse(null);
    }

    private FeeDto feeDtoFromEventContestFee(EventContestFee eventContestFee) {

        if (isNull(eventContestFee.getValue())) {
            return new FeeDto(null, null);
        } else {
            return new FeeDto(BigDecimal.valueOf(eventContestFee.getValue()), eventContestFee.getCurrency());
        }
    }

    protected List<AccommodationDto> accommodationFees(Set<EventContestFee> eventContestFees) {

        return eventContestFees.stream()
                .filter(f -> "ACCOMMODATION".equalsIgnoreCase(f.getKind()))
                .map(accommodationDtoMapper::fromEventContestFee)
                .toList();
    }
}

