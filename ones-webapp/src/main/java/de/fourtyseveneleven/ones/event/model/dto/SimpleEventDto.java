package de.fourtyseveneleven.ones.event.model.dto;


import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.event.model.EventStatus;
import de.fourtyseveneleven.ones.horse.model.SimpleHorseDto;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SimpleEventDto {

    private String uuid;
    private EventStatus status;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

    private String region;
    private List<EventAddressDto> addresses;

    private boolean isNationalChampionship;
    private boolean isInternational;

    private List<SimpleContestDto> contests = new LinkedList<>();

    private Set<SimpleHorseDto> signedUpHorses;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
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

    public List<EventAddressDto> getAddresses() {
        return addresses;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setAddresses(List<EventAddressDto> addresses) {
        this.addresses = addresses;
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

    public Set<SimpleHorseDto> getSignedUpHorses() {
        return signedUpHorses;
    }

    public void setSignedUpHorses(Set<SimpleHorseDto> signedUpHorses) {
        this.signedUpHorses = signedUpHorses;
    }
}
