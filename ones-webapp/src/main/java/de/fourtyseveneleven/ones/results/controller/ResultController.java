package de.fourtyseveneleven.ones.results.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@AuthenticatedApiController
@RequestMapping("/api/v1/results")
public class ResultController {

    @GetMapping("/my")
    public List<ResultDto> getMyResults() {

        return Collections.emptyList();
    }
}
