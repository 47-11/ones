package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class ResultOverviewDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5474871140959182153L;

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
                .map(ContestDto::getDistance)
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
