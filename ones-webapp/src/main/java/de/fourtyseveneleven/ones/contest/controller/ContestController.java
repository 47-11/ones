package de.fourtyseveneleven.ones.contest.controller;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDetailDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestDetailService;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@AuthenticatedApiController
@RequestMapping("/api/v1/contest")
public class ContestController {

    private final ContestService contestService;
    private final ContestDetailService contestDetailService;

    public ContestController(ContestService contestService, ContestDetailService contestDetailService) {
        this.contestService = contestService;
        this.contestDetailService = contestDetailService;
    }

    @GetMapping("")
    public List<ContestDto> findAll(@RequestParam(required = false) String titleContains,
                                    @RequestParam(required = false) String descriptionContains,
                                    @RequestParam(required = false) LocalDateTime startsBefore,
                                    @RequestParam(required = false) LocalDateTime startsAfter,
                                    @RequestParam(required = false) LocalDateTime endsBefore,
                                    @RequestParam(required = false) LocalDateTime endsAfter,
                                    @RequestParam(required = false) Long organizerId) {

        final var filter = new ContestFilterDto(titleContains, descriptionContains, startsBefore, startsAfter,
                endsBefore, endsAfter, organizerId);

        return contestService.findAll(filter);
    }

    @GetMapping("/{uuid}")
    public ContestDetailDto getDetails(@PathVariable String uuid) {

        return contestDetailService.findOneByContestUuid(uuid)
                .orElse(null);
    }
}
