package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.model.SortDirection;
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
import de.fourtyseveneleven.ones.security.util.UserUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.util.Objects.isNull;

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

        final EventContest eventContest = eventContestControllerApi.getContestByUuid(eventUuid, UserUtils.getAuthenticatedUser().getUuid().toString());
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

        return eventContestControllerApi
                .getContestByYear(atStartOfDay(filter.from()),
                        atEndOfDay(filter.until()),
                        filter.regions(),
                        filter.categories(),
                        booleanToInteger(filter.isCountryChampionship()),
                        booleanToInteger(filter.isInternational()),
                        booleanToInteger(filter.isMap()),
                        null,
                        pageRequest.getPageNumber(),
                        pageRequest.getPageSize(),
                        getSortByValue(sortRequest));
    }

    private OffsetDateTime atStartOfDay(LocalDate localDate) {

        if (isNull(localDate)) {
            return null;
        } else {
            final ZonedDateTime atStartOfDay = localDate.atStartOfDay(ZoneOffset.systemDefault());
            return OffsetDateTime.from(atStartOfDay);
        }
    }

    private OffsetDateTime atEndOfDay(LocalDate localDate) {

        if (isNull(localDate)) {
            return null;
        } else {
            final ZonedDateTime atEndOfDay = localDate.atTime(23, 59, 59).atZone(ZoneId.systemDefault());
            return OffsetDateTime.from(atEndOfDay);
        }
    }

    private Integer booleanToInteger(Boolean filterValue) {

        if (isNull(filterValue)) {
            return null;
        } else if (filterValue) {
            return 1;
        } else {
            return 0;
        }
    }

    private String getSortByValue(SortRequest sortRequest) {

        final String attributeName = sortRequest.getAttributeName();
        if (isNull(attributeName)) {
            return null;
        }

        final String mappedAttributeName = mapSortByAttributeName(attributeName);
        final String sortDirectionSuffix = getSortDirectionSuffix(sortRequest.getSortDirection());
        return mappedAttributeName +  sortDirectionSuffix;
    }

    private String mapSortByAttributeName(String attributeName) {

        return switch (attributeName.toLowerCase().trim()) {
            case "title" -> "title";
            case "start" -> "beginning";
            case "end" -> "ending";
            default -> throw new IllegalArgumentException("Can't sort by " + attributeName);
        };
    }

    private String getSortDirectionSuffix(SortDirection sortDirection) {

        return " " + switch (sortDirection) {
            case ASCENDING -> "ASC";
            case DESCENDING -> "DESC";
        };
    }

    private PageDto<SimpleEventDto> pageDtoFromResponcePageContestsPlain(ResponcePageContestsPlain responcePageContestsPlain, PageRequest pageRequest) {

        final PageDto<SimpleEventDto> page = eventPageMapper.map(responcePageContestsPlain);
        page.setPageNumber(pageRequest.getPageNumber());
        page.setPageSize(pageRequest.getPageSize());
        return page;
    }
}
