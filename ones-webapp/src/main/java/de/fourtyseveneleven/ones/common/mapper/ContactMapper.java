package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Mapper(
        componentModel = "spring"
)
public abstract class ContactMapper {

    @Autowired
    protected MasterdataContactControllerApi masterdataContactControllerApi;

    @Named(value = "contactUuidToPersonDto")
    public PersonDto contactUuidToAddressDto(String contactUuid) throws ApiException {

        if (isBlank(contactUuid)) {
            return null;
        } else {
            return doMapContactUuidToAddressDto(contactUuid);
        }
    }

    private PersonDto doMapContactUuidToAddressDto(String contactUuid) throws ApiException {

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
