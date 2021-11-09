package de.fourtyseveneleven.ones.user.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAddress;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredAccount;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public interface UserDtoMapper {

    @Mapping(source = "firstName", target = "user.forename")
    @Mapping(source = "lastName", target = "user.surname")
    @Mapping(source = "birthName", target = "user.birthname")
    @Mapping(source = "phoneNumber", target = "user.phoneNumber")
    @Mapping(source = "phoneNumberMobile", target = "user.phoneNumberMobile")
    @Mapping(source = "phoneNumberEmergency", target = "user.emergencyPhoneNumber")
    @Mapping(source = "emailAddress", target = "user.email")
    @Mapping(source = "address", target = "user.postalAddress")
    @Mapping(source = "vddNumber", target = "memberships.vddMemberId")
    @Mapping(source = "feiNumber", target = "memberships.feiMemberId")
    @Mapping(source = "fnNumber", target = "memberships.fnMemberId")
    RegisterAccount userDtoToRegisterAccount(UserDto userDto);

    RegisterAddress addressDtoFoRegisterAddress(AddressDto addressDto);

    @Mapping(source = "user.forename", target = "firstName")
    @Mapping(source = "user.surname", target = "lastName")
    @Mapping(source = "user.birthname", target = "birthName")
    @Mapping(source = "user.birthday", target = "birthday")
    @Mapping(source = "user.phoneNumber", target = "phoneNumber")
    @Mapping(source = "user.phoneNumberMobile", target = "phoneNumberMobile")
    @Mapping(source = "user.emergencyPhoneNumber", target = "phoneNumberEmergency")
    @Mapping(source = "user.email", target = "emailAddress")
    @Mapping(source = "user.postalAddress", target = "address")
    @Mapping(source = "memberships.vddMemberId", target = "vddNumber")
    @Mapping(source = "memberships.vddQualificationLevel", target = "qualificationLevel")
    // TODO: @Mapping(source = "?", target = "qualificationLevelApproved")
    @Mapping(source = "memberships.feiMemberId", target = "feiNumber")
    @Mapping(source = "memberships.fnMemberId", target = "fnNumber")
    UserDto registeredAccountToUserDto(RegisteredAccount registeredAccount);

    AddressDto registerAddressToAddressDto(RegisterAddress registerAddress);
}
