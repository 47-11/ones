package de.fourtyseveneleven.ones.event.model.dto;

import java.util.List;

public class SignupRequestDto {

    private List<String> horseUuids;

    public List<String> getHorseUuids() {
        return horseUuids;
    }

    public void setHorseUuids(List<String> horseUuids) {
        this.horseUuids = horseUuids;
    }
}
