package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.AddressMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestFeePlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestLocationPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRemarkPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRolePlain;
import de.fourtyseveneleven.ones.event.model.dto.EventAddressDto;
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
                AddressMapper.class,
                EventStatusMapper.class,
                SimpleContestMapper.class
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
    @Mapping(source = "isCard", target = "isMap")
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
    @Mapping(source = "paymentReason", target = "paymentInformation.remarks")
    @Mapping(source = "paymentAccountHolder", target = "paymentInformation.bankTransferAccountHolder")
    @Mapping(source = "paymentIban", target = "paymentInformation.bankTransferIban")
    @Mapping(source = "paymentBic", target = "paymentInformation.bankTransferBic")
    @Mapping(source = "paymentPaypal", target = "paymentInformation.paypalInformation")
    public abstract FullEventDto eventContestPlainToFullEventDto(EventContestPlain eventContest);

    protected List<String> remarksToAdditionalComments(Set<EventContestRemarkPlain> remarks) {

        return remarks.stream()
                .map(EventContestRemarkPlain::getDescription)
                .toList();
    }

    @Named("eventHostFromRoles")
    protected PersonDto eventHostFromRoles(Set<EventContestRolePlain> roles) {

        return findPersonByRoleKind(roles, "PROMOTER");
    }

    @Named("eventOrganizerFromRoles")
    protected PersonDto eventOrganizerFromRoles(Set<EventContestRolePlain> roles) {

        return findPersonByRoleKind(roles, "ORGANIZER");
    }

    @Named("contactPersonFromRoles")
    protected PersonDto contactPersonFromRoles(Set<EventContestRolePlain> roles) {

        return findPersonByRoleKind(roles, "REGISTRATION");
    }

    private PersonDto findPersonByRoleKind(Set<EventContestRolePlain> roles, String roleKind) {

        return roles.stream()
                .filter(role -> roleKind.equalsIgnoreCase(role.getKind()))
                .findFirst()
                .map(this::personDtoFromRole)
                .orElse(null);
    }

    private PersonDto personDtoFromRole(EventContestRolePlain role) {

        final PersonDto personDto = new PersonDto();
        personDto.setFirstName(role.getName1());
        personDto.setLastName(role.getName2());

        personDto.setAddress(addressDtoFromRole(role));
        if (isNotBlank(role.getPhone())) {
            personDto.setPhoneNumber(role.getPhone());
        } else {
            personDto.setPhoneNumber(role.getCellPhone());
        }
        personDto.setEmailAddress(role.getEmail());

        return personDto;
    }

    private AddressDto addressDtoFromRole(EventContestRolePlain role) {

        final AddressDto addressDto = new AddressDto();
        addressDto.setStreet(role.getStreet());
        addressDto.setCity(role.getCity());
        addressDto.setZipCode(role.getZipcode());
        addressDto.setCountry(role.getCountry());

        return addressDto;
    }

    @Named("lateSignupFee")
    protected FeeDto lateSignupFee(Set<EventContestFeePlain> fees) {

        return fees.stream()
                .filter(f -> "ADMINISTRATION".equalsIgnoreCase(f.getKind()))
                .filter(f -> "REGISTRATION_LATE".equalsIgnoreCase(f.getKey()))
                .map(this::feeDtoFromEventContestFee)
                .findFirst()
                .orElse(null);
    }

    @Named("signupChangeFee")
    protected FeeDto signupChangeFee(Set<EventContestFeePlain> fees) {

        return fees.stream()
                .filter(f -> "ADMINISTRATION".equalsIgnoreCase(f.getKind()))
                .filter(f -> "REGISTRATION_CHANGE".equalsIgnoreCase(f.getKey()))
                .map(this::feeDtoFromEventContestFee)
                .findFirst()
                .orElse(null);
    }

    private FeeDto feeDtoFromEventContestFee(EventContestFeePlain eventContestFee) {

        if (isNull(eventContestFee.getValue())) {
            return new FeeDto(null, null);
        } else {
            return new FeeDto(BigDecimal.valueOf(eventContestFee.getValue()), eventContestFee.getCurrency());
        }
    }
}

