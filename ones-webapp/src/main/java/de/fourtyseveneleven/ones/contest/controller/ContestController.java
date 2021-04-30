package de.fourtyseveneleven.ones.contest.controller;

import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contest")
public class ContestController {

    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping("/{id}")
    public ContestDto findOneById(@PathVariable long id) {

        return contestService.findOneById(id).orElseThrow(ElementNotFoundException::new);
    }

    @GetMapping("")
    public List<ContestDto> findAll(@RequestParam(required = false) ContestFilterDto filter) {

        return contestService.findAll(filter);
    }
}
