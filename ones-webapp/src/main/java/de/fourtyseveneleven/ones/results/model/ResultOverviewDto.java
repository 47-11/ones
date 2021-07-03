package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public record ResultOverviewDto(List<ResultDto> results, BigDecimal totalDistance, int totalDuration, BigDecimal averageSpeed) {

    public ResultOverviewDto(List<ResultDto> results) {
        this(results, calculateTotalDistance(results), calculateTotalDuration(results), calculateAverageSpeed(results));
    }

    private static BigDecimal calculateTotalDistance(List<ResultDto> results) {

        return results.stream()
                .map(ResultDto::contest)
                .map(SimpleContestDto::getDistance)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static int calculateTotalDuration(List<ResultDto> results) {

        return results.stream()
                .map(ResultDto::duration)
                .filter(Objects::nonNull)
                .reduce(0, Integer::sum);
    }

    private static BigDecimal calculateAverageSpeed(List<ResultDto> results) {

        final var numberOfResults = BigDecimal.valueOf(results.size());
        return results.stream()
                .map(ResultDto::averageSpeed)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(numberOfResults, 2, RoundingMode.HALF_UP);
    }
}
