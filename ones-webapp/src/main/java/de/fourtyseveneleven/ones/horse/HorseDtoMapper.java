package de.fourtyseveneleven.ones.horse;

import de.fourtyseveneleven.ones.common.mapper.AddressDtoMapper;
import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactLegal;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredHorse;
import de.fourtyseveneleven.ones.horse.model.Gender;
import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
import de.fourtyseveneleven.ones.user.mapper.UserDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse.GenderEnum.G;
import static de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse.GenderEnum.M;
import static de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse.GenderEnum.S;
import static de.fourtyseveneleven.ones.horse.model.Gender.GELDING;
import static de.fourtyseveneleven.ones.horse.model.Gender.MARE;
import static de.fourtyseveneleven.ones.horse.model.Gender.STALLION;

@Mapper(componentModel = "spring", uses = {CommonMapper.class, UserDtoMapper.class, AddressDtoMapper.class})
public abstract class HorseDtoMapper {

    @Mapping(source = "passportNumber", target = "passportId")
    @Mapping(source = "chipNumber", target = "chipId")
    @Mapping(source = "size", target = "stickSize")
    @Mapping(source = "stableAddress", target = "stable.postalAddress")
    public abstract RegisterHorse horseDtoToRegisterHorse(FullHorseDto fullHorseDto);

    @Mapping(source = "passportId", target = "passportNumber")
    @Mapping(source = "chipId", target = "chipNumber")
    @Mapping(source = "stickSize", target = "size")
    @Mapping(source = "stable", target = "stableAddress")
    public abstract FullHorseDto registeredHorseToHorseDto(RegisteredHorse masterdataHorse);

    protected abstract AddressDto registerContactLegalToAddressDto(RegisterContactLegal registerContactLegal);

    protected RegisterHorse.GenderEnum mapGender(Gender gender) {

        return switch (gender) {
            case GELDING -> G;
            case MARE -> M;
            case STALLION -> S;
        };
    }

    protected Gender mapGender(String genderText) {

        return switch (RegisterHorse.GenderEnum.fromValue(genderText)) {
            case G -> GELDING;
            case M -> MARE;
            case S -> STALLION;
        };
    }
}
