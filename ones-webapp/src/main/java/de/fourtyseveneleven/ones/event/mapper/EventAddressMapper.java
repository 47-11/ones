package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestLocation;
import de.fourtyseveneleven.ones.event.model.dto.EventAddressDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventAddressMapper {

    @Mapping(source = "name1", target = "locationName")
    @Mapping(source = "zipcode", target = "zipCode")
    EventAddressDto fromEcmDto(EventContestLocation ecmDto);

    @AfterMapping
    default void fromEcmDtoAfterMapping(EventContestLocation ecmDto, @MappingTarget EventAddressDto addressDto) {

        addressDto.setStreet(ecmDto.getStreet() + " " + ecmDto.getHouseNumber());
    }
}
