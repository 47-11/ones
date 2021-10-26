package de.fourtyseveneleven.ones.horse;

import de.fourtyseveneleven.ones.common.mapper.AddressDtoMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.*;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.user.mapper.UserDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public abstract class HorseDtoMapper {

    @Autowired
    private UserDtoMapper userDtoMapper;
    @Autowired
    private AddressDtoMapper addressDtoMapper;

    // TODO: Map gender
    @Mapping(source = "passportId", target = "passportNumber")
    @Mapping(source = "stickSize", target = "size")
    @Mapping(source = "stables", target = "stableAddress")
    @Mapping(source = "ownersx", target = "owner")
    public abstract HorseDto masterdataHorseToHorseDto(MasterdataHorse masterdataHorse);

    protected AddressDto addressDtoFromStableAddresses(Set<MasterdataHorseStable> masterdataHorseStables) {

        final MasterdataContact masterdataContact = masterdataHorseStables.stream()
                .findFirst()
                .map(MasterdataHorseStable::getContact)
                .orElse(null);
        if (isNull(masterdataContact)) {
            return null;
        }

        final List<MasterdataContactAddress> addresses = masterdataContact.getAddresses();
        if (isNull(addresses) || addresses.isEmpty()) {
            return null;
        }

        return addressDtoMapper.addressDtoFromMasterdataContactAddress(addresses.get(0));
    }

    protected PersonDto personDtoFromMasterdataHorseOwners(Set<MasterdataHorseOwner> masterdataHorseOwners) {

        final MasterdataContact masterdataContact =  masterdataHorseOwners.stream()
                .findFirst()
                .map(MasterdataHorseOwner::getContact)
                .orElse(null);

        if (isNull(masterdataContact)) {
            return null;
        }

        return userDtoMapper.masterdataContactToUserDto(masterdataContact);
    }

    protected String mapMasterdataPropertyCharacteristic(MasterdataPropertyCharacteristic masterdataPropertyCharacteristic) {

        return Optional.ofNullable(masterdataPropertyCharacteristic)
                .map(MasterdataPropertyCharacteristic::getDisplay)
                .orElse(null);
    }
}
