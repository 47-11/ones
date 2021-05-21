package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class ResultOverviewDto {

    private List<ResultDto> results = new LinkedList<>();

    public ResultOverviewDto() {
    }

    public ResultOverviewDto(List<ResultDto> results) {

        this.results = results;
    }

    public List<ResultDto> getResults() {
        return results;
    }

    public void setResults(List<ResultDto> results) {
        this.results = results;
    }

    /**
     * In km/h
     */
    public BigDecimal getTotalDistance() {

        return results.stream()
                .map(ResultDto::getContest)
                .map(SimpleContestDto::getDistance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * In km/h
     */
    public BigDecimal getAverageSpeed() {

        final var numberOfResults = BigDecimal.valueOf(results.size());
        return results.stream()
                .map(ResultDto::getAverageSpeed)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(numberOfResults, 2, RoundingMode.HALF_UP);
    }
}
