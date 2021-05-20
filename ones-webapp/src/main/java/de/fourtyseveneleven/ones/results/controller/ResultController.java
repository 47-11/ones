package de.fourtyseveneleven.ones.results.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AuthenticatedApiController
@RequestMapping("/api/v1/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/my")
    public ResultOverviewDto getMyResults() {

        return resultService.getMyResults();
    }
}
