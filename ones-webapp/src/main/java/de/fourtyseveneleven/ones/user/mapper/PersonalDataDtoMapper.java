package de.fourtyseveneleven.ones.user.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;
import de.fourtyseveneleven.ones.user.model.dto.PersonalDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalDataDtoMapper {

    @Mapping(source = "firstName", target = "forename")
    @Mapping(source = "lastName", target = "surname")
    @Mapping(source = "street", target = "postalAddress.street")
    @Mapping(source = "houseNumber", target = "postalAddress.houseNumber")
    @Mapping(source = "zipCode", target = "postalAddress.zipCode")
    @Mapping(source = "city", target = "postalAddress.city")
    @Mapping(source = "country", target = "postalAddress.country")
    RegisterContact personalDataDtoToRegisterContact(PersonalDataDto personalDataDto);
}
