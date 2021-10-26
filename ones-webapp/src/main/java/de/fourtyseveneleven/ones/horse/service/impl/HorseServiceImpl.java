package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorse;
import de.fourtyseveneleven.ones.horse.HorseDtoMapper;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import de.fourtyseveneleven.ones.security.util.UserUtils;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.util.stream.Collectors.toList;

@Service
@Primary
public class HorseServiceImpl implements HorseService {

    private final MasterdataHorseControllerApi masterdataHorseControllerApi;
    private final HorseDtoMapper horseDtoMapper;


    public HorseServiceImpl(MasterdataHorseControllerApi masterdataHorseControllerApi, HorseDtoMapper horseDtoMapper) {
        this.masterdataHorseControllerApi = masterdataHorseControllerApi;
        this.horseDtoMapper = horseDtoMapper;
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
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    private List<MasterdataHorse> tryGetHorsesFromEcm(User user) throws ApiException {

        final String userUuid = user.getUuid().toString();
        return masterdataHorseControllerApi.getHorsesByContactUuid(userUuid);
    }

}
