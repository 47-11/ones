package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterNomination;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterNominationHorse;
import de.fourtyseveneleven.ones.event.model.dto.SignupDto;
import de.fourtyseveneleven.ones.event.service.SignupService;
import de.fourtyseveneleven.ones.security.util.UserUtils;
import de.fourtyseveneleven.ones.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.stream.Collectors.toList;

@Service
public class EcmApiSignupServiceImpl implements SignupService {

    private final EventContestControllerApi eventContestControllerApi;

    public EcmApiSignupServiceImpl(EventContestControllerApi eventContestControllerApi) {
        this.eventContestControllerApi = eventContestControllerApi;
    }

    @Override
    public void signup(SignupDto signup) {

        final String userUuid = getAuthenticatedUser().getUuid().toString();
        final RegisterNomination request = buildRegisterNomination(signup);

        try {
            eventContestControllerApi.postAccountNomination(userUuid, request);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private RegisterNomination buildRegisterNomination(SignupDto signupDto) {

        final RegisterNomination registerNomination = new RegisterNomination();
        registerNomination.setCompetitionUuid(signupDto.getContestUuid());
        registerNomination.setHorses(buildRegisterNominationHorses(signupDto));

        return registerNomination;
    }

    private List<RegisterNominationHorse> buildRegisterNominationHorses(SignupDto signupDto) {

        return signupDto.getHorseUuids().stream().map(this::buildRegisterNominationHorse).collect(toList());
    }

    private RegisterNominationHorse buildRegisterNominationHorse(String uuid) {

        final RegisterNominationHorse registerNominationHorse = new RegisterNominationHorse();
        registerNominationHorse.setHorseUuid(uuid);

        return registerNominationHorse;
    }
}
