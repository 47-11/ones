package de.fourtyseveneleven.ones.user.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public abstract class UserDtoMapper {

    @Mapping(source = "firstName", target = "forename")
    @Mapping(source = "lastName", target = "surname")
    @Mapping(source = "birthName", target = "birthname")
    @Mapping(source = "phoneNumberEmergency", target = "emergencyPhoneNumber")
    @Mapping(source = "feiNumber", target = "feiMemberId")
    @Mapping(source = "fnNumber", target = "fnMemberId")
    @Mapping(source = "qualificationLevel", target = "vddQualificationLevel")
    @Mapping(source = "address.street", target = "postalAddress.street")
    @Mapping(source = "address.houseNumber", target = "postalAddress.houseNumber")
    @Mapping(source = "address.zipCode", target = "postalAddress.zipCode")
    @Mapping(source = "address.city", target = "postalAddress.city")
    @Mapping(source = "address.country", target = "postalAddress.country")
    public abstract RegisterContact userDtoToRegisterContact(UserDto userDto);

    @Mapping(source = "forename", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    @Mapping(source = "bornName", target = "birthName")
    @Mapping(source = "bornDate", target = "birthday")
    @Mapping(source = "phonePrivate", target = "phoneNumber")
    @Mapping(source = "cellPhonePrivate", target = "phoneNumberMobile")
    // TODO: @Mapping(source = "?", target = "phoneNumberEmergency")
    @Mapping(source = "emailPrivate", target = "emailAddress")
    // TODO: @Mapping(source = "?", target = "qualificationLevel")
    // TODO: @Mapping(source = "?", target = "qualificationLevelApproved")
    @Mapping(source = "addresses", target = "address")
    public abstract UserDto masterdataContactToUserDto(MasterdataContact masterdataContact);

    protected AddressDto masterdataContactAddressesToAddressDto(List<MasterdataContactAddress> masterdataContactAddresses) {

        if (isNull(masterdataContactAddresses) || masterdataContactAddresses.isEmpty()) {
            return null;
        } else {
            return masterdataContactAddressToAddressDto(masterdataContactAddresses.get(0));
        }
    }

    @Mapping(source = "zipcodeCode", target = "zipCode")
    public abstract AddressDto masterdataContactAddressToAddressDto(MasterdataContactAddress masterdataContactAddress);
}
