package de.fourtyseveneleven.ones.event.model.dto;

import java.util.List;

public class SignupDto {

    private String contestUuid;
    private List<String> horseUuids;

    public SignupDto() {
    }

    public SignupDto(String contestUuid, SignupRequestDto signupRequestDto) {

        this.contestUuid = contestUuid;
        this.horseUuids = signupRequestDto.getHorseUuids();
    }

    public String getContestUuid() {
        return contestUuid;
    }

    public void setContestUuid(String contestUuid) {
        this.contestUuid = contestUuid;
    }

    public List<String> getHorseUuids() {
        return horseUuids;
    }

    public void setHorseUuids(List<String> horseUuids) {
        this.horseUuids = horseUuids;
    }
}
