package de.fourtyseveneleven.ones.event.model.dto;

import java.time.LocalDate;
import java.util.List;

public class EventFilterDto {

    private LocalDate from;
    private LocalDate until;
    private Boolean isCountryChampionship;
    private Boolean isInternational;
    private Boolean isCard;
    private List<String> regions;

    public EventFilterDto() {
    }

    public EventFilterDto(LocalDate from, LocalDate until, Boolean isCountryChampionship, Boolean isInternational,
                          Boolean isCard, List<String> regions) {
        this.from = from;
        this.until = until;
        this.isCountryChampionship = isCountryChampionship;
        this.isInternational = isInternational;
        this.isCard = isCard;
        this.regions = regions;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Boolean getIsCountryChampionship() {
        return isCountryChampionship;
    }

    public void setIsCountryChampionship(Boolean countryChampionship) {
        isCountryChampionship = countryChampionship;
    }

    public Boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(Boolean international) {
        isInternational = international;
    }

    public Boolean getIsCard() {
        return isCard;
    }

    public void setIsCard(Boolean card) {
        isCard = card;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}
