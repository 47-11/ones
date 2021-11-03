package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;
import de.fourtyseveneleven.ones.horse.HorseDtoMapper;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import de.fourtyseveneleven.ones.security.util.UserUtils;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Primary
public class HorseServiceImpl implements HorseService {

    private final MasterdataHorseControllerApi masterdataHorseControllerApi;
    private final HorseDtoMapper horseDtoMapper;
    private final UserService userService;

    public HorseServiceImpl(MasterdataHorseControllerApi masterdataHorseControllerApi, HorseDtoMapper horseDtoMapper, UserService userService) {
        this.masterdataHorseControllerApi = masterdataHorseControllerApi;
        this.horseDtoMapper = horseDtoMapper;
        this.userService = userService;
    }

    @Override
    public List<HorseDto> getMyHorses() {

        final User authenticatedUser = UserUtils.getAuthenticatedUser();
        return getHorsesFromEcm(authenticatedUser)
                .stream()
                .map(horseDtoMapper::masterdataHorseToHorseDto)
                .collect(toList());
    }

    private List<MasterdataHorse> getHorsesFromEcm(User user) {

        try {
            return tryGetHorsesFromEcm(user);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private List<MasterdataHorse> tryGetHorsesFromEcm(User user) throws ApiException {

        final String userUuid = user.getUuid().toString();
        return masterdataHorseControllerApi.getHorsesByContactUuid(userUuid);
    }

    @Override
    public void createHorseForCurrentUser(HorseDto horse) {

        try {
            tryCreateHorse(horse);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private void tryCreateHorse(HorseDto horse) throws ApiException {

        final RegisterHorse registerHorseRequest = horseDtoMapper
                .horseDtoToRegisterHorse(horse);
        masterdataHorseControllerApi.postRegisterHorse(registerHorseRequest);
    }
}
