package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.model.dto.PageDto;
import de.fourtyseveneleven.ones.common.model.dto.PageRequest;
import de.fourtyseveneleven.ones.common.model.dto.SortRequest;
import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.ResponcePageContestsPlain;
import de.fourtyseveneleven.ones.event.mapper.EventPageMapper;
import de.fourtyseveneleven.ones.event.mapper.SimpleEventMapper;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
@Primary
@Qualifier("ecmApiSimpleEventServiceImpl")
public class EcmApiSimpleEventServiceImpl implements SimpleEventService {

    private final EventContestControllerApi eventContestControllerApi;
    private final SimpleEventMapper simpleEventMapper;
    private final EventPageMapper eventPageMapper;

    public EcmApiSimpleEventServiceImpl(EventContestControllerApi eventContestControllerApi, SimpleEventMapper simpleEventMapper, EventPageMapper eventPageMapper) {
        this.eventContestControllerApi = eventContestControllerApi;
        this.simpleEventMapper = simpleEventMapper;
        this.eventPageMapper = eventPageMapper;
    }

    @Override
    public Optional<SimpleEventDto> findOneByUuid(String eventUuid) {

        try {
            return tryFindOneByUuid(eventUuid);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    private Optional<SimpleEventDto> tryFindOneByUuid(String eventUuid) throws ApiException {

        final EventContest eventContest = eventContestControllerApi.getContestByUuid(eventUuid);
        return Optional.ofNullable(eventContest)
                .map(simpleEventMapper::eventContestToSimpleEventDto);
    }

    @Override
    public PageDto<SimpleEventDto> findAll(EventFilterDto filter, PageRequest pageRequest, SortRequest sortRequest) {

        final ResponcePageContestsPlain ecmPage = findPageInEcm(filter, pageRequest, sortRequest);
        return pageDtoFromResponcePageContestsPlain(ecmPage, pageRequest);
    }

    private ResponcePageContestsPlain findPageInEcm(EventFilterDto filter, PageRequest pageRequest, SortRequest sortRequest) {

        try {
            return tryFindPageInEcm(filter, pageRequest, sortRequest);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    private ResponcePageContestsPlain tryFindPageInEcm(EventFilterDto filter, PageRequest pageRequest, SortRequest sortRequest) throws ApiException {

        final Integer year = getYearFromFilter(filter);
        return eventContestControllerApi
                .getContestByYear(year, pageRequest.getPageNumber(), pageRequest.getPageSize(), null);
    }

    private Integer getYearFromFilter(EventFilterDto filter) {

        if (Objects.isNull(filter.getEndsAfter())) {
            return null;
        } else {
            return filter.getEndsAfter().getYear();
        }
    }

    private PageDto<SimpleEventDto> pageDtoFromResponcePageContestsPlain(ResponcePageContestsPlain responcePageContestsPlain, PageRequest pageRequest) {

        final PageDto<SimpleEventDto> page = eventPageMapper.map(responcePageContestsPlain);
        page.setPageNumber(pageRequest.getPageNumber());
        page.setPageSize(pageRequest.getPageSize());
        return page;
    }
}
