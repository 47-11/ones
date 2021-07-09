package de.fourtyseveneleven.ones.results.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResult;
import de.fourtyseveneleven.ones.results.mapper.ResultMapper;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;


@Service
public class EcmApiResultServiceImpl implements ResultService {

    private final EventContestControllerApi eventContestControllerApi;
    private final ResultMapper resultMapper;

    public EcmApiResultServiceImpl(EventContestControllerApi eventContestControllerApi, ResultMapper resultMapper) {
        this.eventContestControllerApi = eventContestControllerApi;
        this.resultMapper = resultMapper;
    }

    @Override
    public ResultOverviewDto getMyResults() {

        final String userUuid = getAuthenticatedUser().getUuid().toString();
        final List<ResultDto> results = getResults(userUuid);
        return new ResultOverviewDto(results);
    }

    private List<ResultDto> getResults(String userUuid) {

        return getResultsFromEcm(userUuid).stream()
                .map(resultMapper::fromEcmDto)
                .toList();
    }

    private List<EventContestCompetitionResult> getResultsFromEcm(String userUuid) {

        try {
            return eventContestControllerApi.getAccountContestCompetitionsResults(userUuid);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }
}
