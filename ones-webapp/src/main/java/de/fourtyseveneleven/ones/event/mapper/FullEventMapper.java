package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRemark;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestRole;
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
    @Mapping(source = "infoVaccinationObligation", target = "vaccinationInformation")
    @Mapping(source = "infoHelmetObligation", target = "helmetInformation")
    @Mapping(source = "remarks", target = "additionalComments")
    @Mapping(source = "countryRegion", target = "region")
    @Mapping(source = "roles", target = "eventHost", qualifiedByName = "eventHostFromRoles")
    @Mapping(source = "roles", target = "eventOrganizer", qualifiedByName = "eventOrganizerFromRoles")
    @Mapping(source = "roles", target = "contactPerson", qualifiedByName = "contactPersonFromRoles")
    @Mapping(source = "promoterEventUrl", target = "organizerWebsiteUrl")
    @Mapping(source = "promoterTenderingUrl", target = "signupDocumentUrl")
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
        personDto.setName(String.format("%s %s %s", role.getName1(), role.getName2(), role.getName3()).trim());
        personDto.setAddress(addressDtoFromRole(role));
        if (isNotBlank(role.getPhone())) {
            personDto.setPhoneNumber(role.getPhone());
        } else {
            personDto.setPhoneNumber(role.getCellPhone());
        }
        personDto.setEmailAddress(role.getEmail());

        return  personDto;
    }

    private AddressDto addressDtoFromRole(EventContestRole role) {

        final AddressDto addressDto = new AddressDto();
        addressDto.setStreet(role.getStreet());
        addressDto.setCity(role.getCity());
        addressDto.setZipCode(role.getZipcode());
        addressDto.setCountry(role.getCountry());

        return addressDto;
    }
}

