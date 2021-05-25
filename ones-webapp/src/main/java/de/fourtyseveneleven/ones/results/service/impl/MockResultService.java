package de.fourtyseveneleven.ones.results.service.impl;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MockResultService implements ResultService {

    private final ContestService contestService;

    private final ResultOverviewDto mockResultOverview;

    public MockResultService(ContestService contestService) {
        this.contestService = contestService;
        this.mockResultOverview = buildMockResultOverview();
    }

    private ResultOverviewDto buildMockResultOverview() {

        return new ResultOverviewDto(buildMockResults());
    }

    private List<ResultDto> buildMockResults() {

        return contestService.findAll(new ContestFilterDto())
                .subList(4, 10)
                .stream()
                .map(this::buildMockResultForContest)
                .collect(toList());
    }

    private ResultDto buildMockResultForContest(ContestDto contest) {

        final var result = new ResultDto();

        result.setContest(contest);
        result.setHorse(buildMockHorse());
        result.setPlacement((int) contest.getId());
        result.setAverageSpeed(BigDecimal.valueOf((Math.random() * 20) + 10));

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