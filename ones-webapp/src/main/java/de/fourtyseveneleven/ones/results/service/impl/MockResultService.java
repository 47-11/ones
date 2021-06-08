package de.fourtyseveneleven.ones.results.service.impl;

import de.fourtyseveneleven.ones.common.model.SortDirection;
import de.fourtyseveneleven.ones.common.model.dto.PageRequest;
import de.fourtyseveneleven.ones.common.model.dto.SortRequest;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MockResultService implements ResultService {

    private final SimpleEventService simpleEventService;

    private final ResultOverviewDto mockResultOverview;

    public MockResultService(@Qualifier("mockSimpleEventServiceImpl") SimpleEventService mockSimpleEventServiceImpl) {
        this.simpleEventService = mockSimpleEventServiceImpl;
        this.mockResultOverview = buildMockResultOverview();
    }

    private ResultOverviewDto buildMockResultOverview() {

        return new ResultOverviewDto(buildMockResults());
    }

    private List<ResultDto> buildMockResults() {

        return simpleEventService.findAll(new EventFilterDto(), new PageRequest(0, 10), new SortRequest("start", SortDirection.ASCENDING))
                .getElements()
                .stream()
                .map(SimpleEventDto::getContests)
                .flatMap(List::stream)
                .map(this::buildMockResultForContest)
                .collect(toList());
    }

    private ResultDto buildMockResultForContest(SimpleContestDto contest) {

        final var result = new ResultDto();

        result.setContest(contest);
        result.setHorses(List.of(buildMockHorse()));
        result.setPlacement(3);
        result.setAverageSpeed(BigDecimal.valueOf(18));

        return result;
    }

    private HorseDto buildMockHorse() {

        final var horse = new HorseDto();
        horse.setLifeNumber("foo");
        horse.setName("Shadowfax");
        horse.setUuid("bar");

        return horse;
    }

    @Override
    public ResultOverviewDto getMyResults() {

        return mockResultOverview;
    }
}
