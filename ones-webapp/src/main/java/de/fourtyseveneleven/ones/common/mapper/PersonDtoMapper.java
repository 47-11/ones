package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public abstract class PersonDtoMapper {

    @Autowired
    protected MasterdataContactControllerApi masterdataContactControllerApi;

    @Named(value = "contactUuidToPersonDto")
    public PersonDto contactUuidToPersonDto(String contactUuid) throws ApiException {

        if (isBlank(contactUuid)) {
            return null;
        } else {
            return masterdataContactToUserDto(masterdataContactControllerApi.getContactByUuid(contactUuid));
        }
    }

    @Mapping(source = "addresses", target = "address")
    @Mapping(source = "forename", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    public abstract UserDto masterdataContactToUserDto(MasterdataContact masterdataContact);

    @Mapping(source = "addresses", target = "address")
    @Mapping(source = "forename", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    public abstract PersonDto masterdataContactToPersonDto(MasterdataContact masterdataContact);


    public AddressDto masterdataContactAddressesToAddressDto(List<MasterdataContactAddress> masterdataContactAddresses) {

        if (masterdataContactAddresses.isEmpty()) {
            return null;
        } else {
            return masterdataContactAddressToAddressDto(masterdataContactAddresses.get(0));
        }
    }

    @Mapping(source = "zipcodeCode", target = "zipCode")
    @Mapping(source = "countryCode", target = "country")
    public abstract AddressDto masterdataContactAddressToAddressDto(MasterdataContactAddress masterdataContactAddress);

    @AfterMapping
    public void afterMasterdataContactAddressToAddressDto(@MappingTarget AddressDto addressDto, MasterdataContactAddress masterdataContactAddress) {

        final String street = format("{0} {1}", masterdataContactAddress.getStreet(), masterdataContactAddress.getHouseNumber());
        addressDto.setStreet(street);
    }
}
