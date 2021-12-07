package de.fourtyseveneleven.ones.results.controller;

import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;
import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AuthenticatedApiController
@RequestMapping("/api/v1/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/my")
    public ResultOverviewDto getMyResults() {
        final SimpleHorseDto horse = new SimpleHorseDto(
                UUID.randomUUID(),
                "Shadowfax"
        );
        final List<SimpleHorseDto> horses = Collections.singletonList(horse);

        final SimpleContestDto contest = new SimpleContestDto();
        contest.setCategory("TEST");
        contest.setDistance(BigDecimal.valueOf(42));

        final SimpleEventDto event = new SimpleEventDto();
        event.setTitle("Demo Event");

        final ResultDto resultDto = new ResultDto(
                contest,
                event,
                horses,
                3,
                7671246,
                BigDecimal.TEN,
                BigDecimal.TEN,
                null);

        return new ResultOverviewDto(Collections.singletonList(resultDto));
    }
}
