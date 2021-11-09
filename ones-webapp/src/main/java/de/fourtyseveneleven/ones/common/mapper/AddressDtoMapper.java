package de.fourtyseveneleven.ones.common.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContestLocation;
import de.fourtyseveneleven.ones.event.model.dto.EventAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressDtoMapper {

    @Mapping(source = "name1", target = "locationName")
    @Mapping(source = "zipcode", target = "zipCode")
    @Mapping(source = "gpsCoordinate", target = "gpsCoordinates")
    EventAddressDto eventAddressDtoFromEventContestLocation(EventContestLocation ecmDto);
}
