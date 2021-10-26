package de.fourtyseveneleven.ones.horse;

import de.fourtyseveneleven.ones.common.mapper.AddressDtoMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.PersonDtoMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.generated.model.*;
import de.fourtyseveneleven.ones.horse.model.Gender;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Objects.isNull;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public abstract class HorseDtoMapper {

    @Autowired
    private PersonDtoMapper personDtoMapper;
    @Autowired
    private AddressDtoMapper addressDtoMapper;

    // TODO: Map gender
    @Mapping(source = "passportId", target = "passportNumber")
    @Mapping(source = "stickSize", target = "size")
    @Mapping(source = "stables", target = "stableAddress")
    @Mapping(source = "ownersx", target = "owner")
    public abstract HorseDto masterdataHorseToHorseDto(MasterdataHorse masterdataHorse);

    protected AddressDto addressDtoFromStableAddresses(List<MasterdataHorseStable> masterdataHorseStables) {

        if (masterdataHorseStables.isEmpty()) {
            return null;
        }

        final MasterdataContact masterdataContact = masterdataHorseStables.get(0).getContact();
        if (isNull(masterdataContact)) {
            return null;
        }

        final List<MasterdataContactAddress> addresses = masterdataContact.getAddresses();
        if (isNull(addresses) || addresses.isEmpty()) {
            return null;
        }

        return addressDtoMapper.addressDtoFromMasterdataContactAddress(addresses.get(0));
    }

    protected PersonDto personDtoFromMasterdataHorseOwners(List<MasterdataHorseOwner> masterdataHorseOwners) {

        if (masterdataHorseOwners.isEmpty()) {
            return null;
        }

        final MasterdataContact masterdataContact = masterdataHorseOwners.get(0).getContact();
        return personDtoMapper.masterdataContactToUserDto(masterdataContact);
    }
}
