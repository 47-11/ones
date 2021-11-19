package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.common.mapper.AddressMapper;
import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactLegal;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactNatural;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredHorse;
import de.fourtyseveneleven.ones.horse.mapper.HorseMapper;
import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import de.fourtyseveneleven.ones.user.mapper.UserMapper;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.stream.Collectors.toList;

@Service
@Primary
public class HorseServiceImpl implements HorseService {

    private final ApplicationAccountControllerApi applicationAccountControllerApi;
    private final MasterdataHorseControllerApi masterdataHorseControllerApi;
    private final HorseMapper horseMapper;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    public HorseServiceImpl(ApplicationAccountControllerApi applicationAccountControllerApi, MasterdataHorseControllerApi masterdataHorseControllerApi, HorseMapper horseMapper, UserMapper userMapper, AddressMapper addressMapper) {
        this.applicationAccountControllerApi = applicationAccountControllerApi;
        this.masterdataHorseControllerApi = masterdataHorseControllerApi;
        this.horseMapper = horseMapper;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<FullHorseDto> getMyHorses() {

        final User authenticatedUser = getAuthenticatedUser();
        return getHorsesFromEcm(authenticatedUser)
                .stream()
                .map(horseMapper::registeredHorseToHorseDto)
                .collect(toList());
    }

    private Set<RegisteredHorse> getHorsesFromEcm(User user) {

        try {
            return tryGetHorsesFromEcm(user);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private Set<RegisteredHorse> tryGetHorsesFromEcm(User user) throws ApiException {

        final String userUuid = user.getUuid().toString();
        return applicationAccountControllerApi.getAccoundByUuid(userUuid).getHorses();
    }

    @Override
    public void createHorseForCurrentUser(FullHorseDto horse) {

        try {
            tryCreateHorse(horse);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private void tryCreateHorse(FullHorseDto horse) throws ApiException {

        final String userUuid = getAuthenticatedUser().getUuid().toString();
        final RegisterHorse registerHorseRequest = horseMapper
                .horseDtoToRegisterHorse(horse);

        masterdataHorseControllerApi.postRegisterHorse(userUuid, registerHorseRequest);
    }

    @Override
    public void update(UUID horseUuid, FullHorseDto horseDto) {

        try {
            tryUpdate(horseUuid, horseDto);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private void tryUpdate(UUID horseUuid, FullHorseDto horseDto) throws ApiException {

        final RegisterHorse toUpdate = findHorseToUpdate(horseUuid.toString())
                .orElseThrow(() -> new IllegalArgumentException("Unknown horse with uuid " + horseUuid));

        final PersonDto editedOwner = horseDto.getOwner();
        final RegisterContactNatural ownerToEdit = toUpdate.getOwner();
        userMapper.applyPersonDtoToRegisterContactNatural(editedOwner, ownerToEdit);

        final AddressDto editedStableAddress = horseDto.getStableAddress();
        final RegisterContactLegal stableAddressToEdit = toUpdate.getStable();
        addressMapper.applyAddressDtoToRegisterContactLegal(editedStableAddress, stableAddressToEdit);

        final String userUuid = getAuthenticatedUser().getUuid().toString();
        // postRegisterHorse is also used to edit a horse
        masterdataHorseControllerApi.postRegisterHorse(userUuid, toUpdate);
    }

    private Optional<RegisterHorse> findHorseToUpdate(String horseUuid) throws ApiException {

        final String authenticatedUserUuid = getAuthenticatedUser().getUuid().toString();

        final Set<RegisteredHorse> horsesForCurrentUser =
                applicationAccountControllerApi.getAccoundByUuid(authenticatedUserUuid).getHorses();

        return Optional.ofNullable(horsesForCurrentUser)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(h -> horseUuid.equals(h.getUuid()))
                .findFirst()
                .map(horseMapper::registeredHorseToRegisterHorse);
    }
}
