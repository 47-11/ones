package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.BaseMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring",
        uses = BaseMapper.class
)
public abstract class FullEventMapper {

    @Autowired
    protected MasterdataContactControllerApi masterdataContactControllerApi;

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
    public abstract FullEventDto fromEcmDto(EventContest eventContest);

    @Named(value = "contactUuidToPersonDto")
    public PersonDto contactUuidToAddressDto(String contactUuid) throws ApiException {

        final MasterdataContact contact = masterdataContactControllerApi.getContactByUuid(contactUuid);
        final PersonDto person = new PersonDto();
        person.setName(contact.getForename() + " " + contact.getSurname());
        person.setEmailAddress(getEmailAddressFromMasterdataContact(contact));
        person.setPhoneNumber(getPhoneNumberFromMasterdataContact(contact));
        person.setAddress(buildAddressFromMasterdataContact(contact));

        return person;
    }

    private String getEmailAddressFromMasterdataContact(MasterdataContact masterdataContact) {

        if (isNotBlank(masterdataContact.getEmailBusiness())) {
            return masterdataContact.getEmailBusiness();
        } else {
            return masterdataContact.getEmailPrivate();
        }
    }

    private String getPhoneNumberFromMasterdataContact(MasterdataContact masterdataContact) {

        if (isNotBlank(masterdataContact.getPhoneBusiness())) {
            return masterdataContact.getPhoneBusiness();
        } else if (isNotBlank(masterdataContact.getCellPhoneBusiness())){
            return masterdataContact.getCellPhoneBusiness();
        } else if (isNotBlank(masterdataContact.getPhonePrivate())) {
            return masterdataContact.getPhonePrivate();
        } else {
            return masterdataContact.getCellPhonePrivate();
        }
    }

    private AddressDto buildAddressFromMasterdataContact(MasterdataContact masterdataContact) {

        if (isNull(masterdataContact.getAddresses()) || masterdataContact.getAddresses().isEmpty()) {
            return null;
        }

        final MasterdataContactAddress ecmAddress = masterdataContact.getAddresses().get(0);
        final AddressDto address = new AddressDto();
        address.setStreet(ecmAddress.getStreet() + " " + ecmAddress.getHouseNumber());
        address.setCity(ecmAddress.getCity());
        address.setZipCode(ecmAddress.getZipcodeCode());
        address.setCountry(ecmAddress.getCountryCode());

        return address;
    }
}

