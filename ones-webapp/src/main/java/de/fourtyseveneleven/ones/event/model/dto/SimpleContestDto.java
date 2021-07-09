package de.fourtyseveneleven.ones.event.model.dto;

import java.math.BigDecimal;

public class SimpleContestDto {

    private String uuid;

    private String category;
    private BigDecimal distance;

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
}
