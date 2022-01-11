package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;

import java.math.BigDecimal;
import java.util.Set;

public class SimpleContestDto {

    private String uuid;

    private String category;
    private BigDecimal distance;

    private Set<SimpleHorseDto> signedUpHorses;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Set<SimpleHorseDto> getSignedUpHorses() {
        return signedUpHorses;
    }

    public void setSignedUpHorses(Set<SimpleHorseDto> signedUpHorses) {
        this.signedUpHorses = signedUpHorses;
    }
}
