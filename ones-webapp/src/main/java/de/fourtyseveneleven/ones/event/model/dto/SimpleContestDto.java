package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.event.model.ContestType;

import java.math.BigDecimal;

public class SimpleContestDto {

    private String uuid;

    private ContestType contestType;
    /**
     * In km
     */
    private BigDecimal distance;

    private boolean isCardRide;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ContestType getContestType() {
        return contestType;
    }

    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public boolean isCardRide() {
        return isCardRide;
    }

    public void setCardRide(boolean cardRide) {
        isCardRide = cardRide;
    }
}
