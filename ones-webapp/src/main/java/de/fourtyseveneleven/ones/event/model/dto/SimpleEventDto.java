package de.fourtyseveneleven.ones.event.model.dto;


import de.fourtyseveneleven.ones.common.model.dto.AddressDto;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class SimpleEventDto {

    private String uuid;

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

    private AddressDto address;

    private boolean isNationalChampionship;
    private boolean isInternational;

    private List<SimpleContestDto> contests = new LinkedList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public boolean getIsNationalChampionship() {
        return isNationalChampionship;
    }

    public void setIsNationalChampionship(boolean isNationalChampionship) {
        this.isNationalChampionship = isNationalChampionship;
    }

    public boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }

    public List<SimpleContestDto> getContests() {
        return contests;
    }

    public void setContests(List<SimpleContestDto> contests) {
        this.contests = contests;
    }
}
