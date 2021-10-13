package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public abstract class PersonDtoMapper {

    @Mapping(source = "addresses", target = "address")
    @Mapping(source = "forename", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    public abstract UserDto masterdataContactToUserDto(MasterdataContact masterdataContact);

    protected AddressDto masterdataContactAddressesToAddressDto(List<MasterdataContactAddress> masterdataContactAddresses) {

        if (masterdataContactAddresses.isEmpty()) {
            return null;
        } else {
            return masterdataContactAddressToAddressDto(masterdataContactAddresses.get(0));
        }
    }

    @Mapping(source = "zipcodeCode", target = "zipCode")
    @Mapping(source = "countryCode", target = "country")
    public abstract AddressDto masterdataContactAddressToAddressDto(MasterdataContactAddress masterdataContactAddress);
}
