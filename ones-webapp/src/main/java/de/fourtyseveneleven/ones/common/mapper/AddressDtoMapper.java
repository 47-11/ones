package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestLocation;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.event.model.dto.EventAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressDtoMapper {

    @Mapping(source = "countryCode", target = "country")
    AddressDto addressDtoFromMasterdataContactAddress(MasterdataContactAddress masterdataContactAddress);

    @Mapping(source = "name1", target = "locationName")
    @Mapping(source = "zipcode", target = "zipCode")
    @Mapping(source = "gpsCoordinate", target = "gpsCoordinates")
    EventAddressDto eventAddressDtoFromeventContestLocation(EventContestLocation ecmDto);
}
