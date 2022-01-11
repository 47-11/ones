package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContestFeePlain;
import de.fourtyseveneleven.ones.event.model.dto.AccommodationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccommodationDtoMapper {

    @Mapping(source = "key", target = "type")
    @Mapping(source = "value", target = "fee.amount")
    @Mapping(source = "currency", target = "fee.currency")
    @Mapping(source = "unit", target = "feeUnit")
    @Mapping(source = "deposit", target = "pledgeFee.amount")
    @Mapping(source = "currency", target = "pledgeFee.currency")
    @Mapping(source = "remark", target = "additionalInformation")
    AccommodationDto fromEventContestFee(EventContestFeePlain eventContestFee);
}
