package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestLocationPlain;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAddress;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactLegal;
import de.fourtyseveneleven.ones.event.model.dto.EventAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto registerAddressToAddressDto(RegisterAddress registerAddress);

    RegisterAddress addressDtoToRegisterAddress(AddressDto addressDto);

    default AddressDto registerContactLegalToAddressDto(RegisterContactLegal registerContactLegal) {

        return Optional.ofNullable(registerContactLegal)
                .map(RegisterContactLegal::getPostalAddress)
                .map(this::registerAddressToAddressDto)
                .orElse(null);
    }

    void applyAddressDtoToRegisterContactLegal(AddressDto addressDto, @MappingTarget RegisterContactLegal registerContactLegal);

    @Mapping(source = "name1", target = "locationName")
    @Mapping(source = "zipcode", target = "zipCode")
    @Mapping(source = "gpsCoordinate", target = "gpsCoordinates")
    EventAddressDto eventAddressDtoFromEventContestLocation(EventContestLocationPlain ecmDto);


}
