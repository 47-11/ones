package de.fourtyseveneleven.ones.event.model.dto;

import java.time.LocalDate;
import java.util.List;

public record EventFilterDto(LocalDate from, LocalDate until, List<String> regions, List<String> categories,
                             Boolean isMap, Boolean isCountryChampionship, Boolean isInternational) {

}
