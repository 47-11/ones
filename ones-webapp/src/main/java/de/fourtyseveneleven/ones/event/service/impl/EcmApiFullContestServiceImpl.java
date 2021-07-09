package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.event.mapper.FullContestMapper;
import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.service.FullContestService;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;

@Service
public class EcmApiFullContestServiceImpl implements FullContestService {

    private final EventContestControllerApi eventContestControllerApi;
    private final FullContestMapper fullContestMapper;

    public EcmApiFullContestServiceImpl(EventContestControllerApi eventContestControllerApi, FullContestMapper fullContestMapper) {
        this.eventContestControllerApi = eventContestControllerApi;
        this.fullContestMapper = fullContestMapper;
    }

    @Override
    public List<FullContestDto> getContestsForEvent(String eventUuid) {

        final EventContest eventContest = getEventContestFromEcm(eventUuid);
        if (isNull(eventContest) || isNull(eventContest.getCompetitions())) {
            return emptyList();
        }

        return eventContest.getCompetitions().stream()
                .map(fullContestMapper::fromEcmDto)
                .toList();
    }

    private EventContest getEventContestFromEcm(String uuid) {

        try {
            return eventContestControllerApi.getContestByUuid(uuid, getAuthenticatedUser().getUuid().toString());
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }
}
