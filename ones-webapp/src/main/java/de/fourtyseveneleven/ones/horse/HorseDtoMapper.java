package de.fourtyseveneleven.ones.horse;

import de.fourtyseveneleven.ones.common.mapper.AddressDtoMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactLegal;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredHorse;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.user.mapper.UserDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CommonMapper.class, UserDtoMapper.class, AddressDtoMapper.class})
public abstract class HorseDtoMapper {

    // TODO: Map gender
    @Mapping(source = "passportNumber", target = "passportId")
    @Mapping(source = "chipNumber", target = "chipId")
    @Mapping(source = "size", target = "stickSize")
    @Mapping(source = "stableAddress", target = "stable.postalAddress")
    public abstract RegisterHorse horseDtoToRegisterHorse(HorseDto horseDto);

    // TODO: Map gender
    @Mapping(source = "passportId", target = "passportNumber")
    @Mapping(source = "chipId", target = "chipNumber")
    @Mapping(source = "stickSize", target = "size")
    @Mapping(source = "stable", target = "stableAddress")
    public abstract HorseDto registeredHorseToHorseDto(RegisteredHorse masterdataHorse);

    protected abstract AddressDto registerContactLegalToAddressDto(RegisterContactLegal registerContactLegal);
}
