package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.event.mapper.FullEventMapper;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import de.fourtyseveneleven.ones.event.service.FullEventService;
import de.fourtyseveneleven.ones.security.util.UserUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
@Primary
@Qualifier("ecmApiFullEventServiceImpl")
public class EcmApiFullEventServiceImpl implements FullEventService {

    private final EventContestControllerApi eventContestControllerApi;
    private final FullEventMapper fullEventMapper;

    public EcmApiFullEventServiceImpl(EventContestControllerApi eventContestControllerApi, FullEventMapper fullEventMapper) {
        this.eventContestControllerApi = eventContestControllerApi;
        this.fullEventMapper = fullEventMapper;
    }

    @Override
    @Cacheable(cacheNames = "events", cacheManager = "eventCacheManager")
    public Optional<FullEventDto> findOneByUuid(String eventUuid) {

        try {
            return tryFindOneByUuid(eventUuid);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private Optional<FullEventDto> tryFindOneByUuid(String eventUuid) throws ApiException {

        final EventContest eventContest = eventContestControllerApi.getContestByUuid(eventUuid, UserUtils.getAuthenticatedUser().getUuid().toString());
        return Optional.ofNullable(eventContest)
                .map(fullEventMapper::eventContestToFullEventDto);
    }
}
