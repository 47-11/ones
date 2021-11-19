package de.fourtyseveneleven.ones.user.mapper;

import de.fourtyseveneleven.ones.common.mapper.AddressMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.*;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CommonMapper.class, AddressMapper.class})
public interface UserMapper {

    @Mapping(source = "firstName", target = "forename")
    @Mapping(source = "lastName", target = "surname")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "phoneNumberMobile", target = "phoneNumberMobile")
    @Mapping(source = "emailAddress", target = "email")
    @Mapping(source = "address", target = "postalAddress")
    RegisterContactNatural personDtoToRegisterContactNatural(PersonDto personDto);

    @InheritConfiguration(name = "personDtoToRegisterContactNatural")
    void applyPersonDtoToRegisterContactNatural(PersonDto personDto, @MappingTarget RegisterContactNatural registerContactNatural);

    @Mapping(source = "birthName", target = "user.birthname")
    @Mapping(source = "phoneNumberEmergency", target = "user.emergencyPhoneNumber")
    @Mapping(source = "vddNumber", target = "memberships.vddMemberId")
    @Mapping(source = "feiNumber", target = "memberships.feiMemberId")
    @Mapping(source = "fnNumber", target = "memberships.fnMemberId")
    @Mapping(source = "firstName", target = "user.forename")
    @Mapping(source = "lastName", target = "user.surname")
    @Mapping(source = "phoneNumber", target = "user.phoneNumber")
    @Mapping(source = "phoneNumberMobile", target = "user.phoneNumberMobile")
    @Mapping(source = "emailAddress", target = "user.email")
    @Mapping(source = "address", target = "user.postalAddress")
    RegisterAccount userDtoToRegisterAccount(UserDto userDto);

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
}
