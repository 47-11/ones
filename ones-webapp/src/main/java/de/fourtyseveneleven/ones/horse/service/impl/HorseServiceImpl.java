package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredHorse;
import de.fourtyseveneleven.ones.horse.HorseDtoMapper;
import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import de.fourtyseveneleven.ones.security.util.UserUtils;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.stream.Collectors.toList;

@Service
@Primary
public class HorseServiceImpl implements HorseService {

    private final ApplicationAccountControllerApi applicationAccountControllerApi;
    private final MasterdataHorseControllerApi masterdataHorseControllerApi;
    private final HorseDtoMapper horseDtoMapper;

    public HorseServiceImpl(ApplicationAccountControllerApi applicationAccountControllerApi, MasterdataHorseControllerApi masterdataHorseControllerApi, HorseDtoMapper horseDtoMapper) {
        this.applicationAccountControllerApi = applicationAccountControllerApi;
        this.masterdataHorseControllerApi = masterdataHorseControllerApi;
        this.horseDtoMapper = horseDtoMapper;
    }

    @Override
    public List<FullHorseDto> getMyHorses() {

        final User authenticatedUser = getAuthenticatedUser();
        return getHorsesFromEcm(authenticatedUser)
                .stream()
                .map(horseDtoMapper::registeredHorseToHorseDto)
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

        final String userUuid = UserUtils.getAuthenticatedUser().getUuid().toString();
        final RegisterHorse registerHorseRequest = horseDtoMapper
                .horseDtoToRegisterHorse(horse);

        masterdataHorseControllerApi.postRegisterHorse(userUuid, registerHorseRequest);
    }
}
