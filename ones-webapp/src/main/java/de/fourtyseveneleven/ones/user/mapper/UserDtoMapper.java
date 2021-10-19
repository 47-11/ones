package de.fourtyseveneleven.ones.user.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

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
    RegisterContact userDtoToRegisterContact(UserDto userDto);
}
