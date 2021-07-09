package de.fourtyseveneleven.ones.event.model.dto;

import java.math.BigDecimal;

public record FeeDto(BigDecimal amount, String currency) {
}
