package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;

import java.math.BigDecimal;
import java.util.List;

public record ResultDto(SimpleContestDto contest, SimpleEventDto event,
                        List<SimpleHorseDto> horses, Integer placement, Integer duration,
                        BigDecimal averageSpeed, BigDecimal pace, String failureReason) {}
