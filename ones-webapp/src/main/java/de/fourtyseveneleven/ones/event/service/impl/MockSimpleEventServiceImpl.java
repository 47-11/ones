package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PageDto;
import de.fourtyseveneleven.ones.common.model.dto.PageRequest;
import de.fourtyseveneleven.ones.common.model.dto.SortRequest;
import de.fourtyseveneleven.ones.event.model.ContestType;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class MockSimpleEventServiceImpl implements SimpleEventService {

    private static final int NUMBER_OF_MOCK_EVENTS = 31;

    private final Map<String, SimpleEventDto> mockEvents;

    public MockSimpleEventServiceImpl() {
        mockEvents = buildMockEvents();
    }

    @Override
    public Optional<SimpleEventDto> findOneByUuid(String eventUuid) {

        return Optional.ofNullable(mockEvents.get(eventUuid));
    }

    @Override
    public PageDto<SimpleEventDto> findAll(EventFilterDto filter, PageRequest pageRequest, SortRequest sortRequest) {

        final Collection<SimpleEventDto> allElements = mockEvents.values();

        final int pageNumber = pageRequest.getPageNumber();
        final int pageSize = pageRequest.getPageSize();
        final int skipElements = pageNumber * pageSize;

        final List<SimpleEventDto> pageElements = allElements
                .stream()
                .skip(skipElements)
                .limit(pageSize)
                .collect(toList());

        final PageDto<SimpleEventDto> page = new PageDto<>();
        page.setElements(pageElements);
        page.setPageNumber(pageRequest.getPageNumber());
        page.setPageSize(pageElements.size());
        page.setTotalElements(allElements.size());

        return page;
    }

    private Map<String, SimpleEventDto> buildMockEvents() {

        final Map<String, SimpleEventDto> result = new HashMap<>();

        for (int i = 0; i < NUMBER_OF_MOCK_EVENTS; i++) {
            final SimpleEventDto event = buildMockEvent(i);
            result.put(event.getUuid(), event);
        }

        return result;
    }

    private SimpleEventDto buildMockEvent(int i) {

        final var result = new SimpleEventDto();
        result.setUuid("Veranstaltung " + i);
        result.setTitle("Veranstaltung " + i);
        result.setStart(LocalDateTime.now().plusDays(i));
        result.setEnd(LocalDateTime.now().plusDays(i).plusDays(2));
        result.setAddress(buildMockAddress());
        result.setContests(buildMockContests());

        return result;
    }

    private AddressDto buildMockAddress() {

        final var result = new AddressDto();
        result.setLocationName("Ortsausgang");
        result.setStreet("Beispielstraße");
        result.setCity("Musterstadt");
        result.setZipCode("0410");
        result.setRegion("NRW");
        result.setCountry("DE");

        return result;
    }

    private List<SimpleContestDto> buildMockContests() {

        return List.of(buildMdrContest(), buildEfrContest());
    }

    private SimpleContestDto buildMdrContest() {

        final var contest = new SimpleContestDto();
        contest.setUuid("uuid_mdr");
        contest.setContestType(ContestType.MEDIUM_DISTANCE_RIDE);
        contest.setDistance(new BigDecimal("54.6"));
        contest.setCardRide(true);

        return contest;
    }

    private SimpleContestDto buildEfrContest() {

        final var contest = new SimpleContestDto();
        contest.setUuid("uuid_efr");
        contest.setContestType(ContestType.INTRODUCTION_RIDE);
        contest.setDistance(new BigDecimal("8.2"));
        contest.setCardRide(false);

        return contest;
    }
}
