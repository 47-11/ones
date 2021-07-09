package de.fourtyseveneleven.ones.results.service.impl;

import de.fourtyseveneleven.ones.results.model.ResultOverviewDto;
import de.fourtyseveneleven.ones.results.service.ResultService;
import org.springframework.stereotype.Service;

@Service
public class MockResultService implements ResultService {

    @Override
    public ResultOverviewDto getMyResults() {

        return new ResultOverviewDto();
    }
}
