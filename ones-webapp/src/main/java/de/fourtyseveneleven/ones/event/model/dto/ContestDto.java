package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.event.model.ContestType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContestDto {

    private ContestType contestType;

    private LocalDate date;

    /**
     * In km
     */
    private BigDecimal distance;
    private BigDecimal altitudeDifference;

    private Integer qualificationLevel;

    private BigDecimal participationPrice;
    private BigDecimal startPrice;

    private String maximumDuration;

    private int minimumHorseAge;
    private int minimumParticipantAge;

    private int currentParticipants;
    private int maximumParticipants;

    public ContestType getContestType() {
        return contestType;
    }

    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getAltitudeDifference() {
        return altitudeDifference;
    }

    public void setAltitudeDifference(BigDecimal altitudeDifference) {
        this.altitudeDifference = altitudeDifference;
    }

    public Integer getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(Integer qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public BigDecimal getParticipationPrice() {
        return participationPrice;
    }

    public void setParticipationPrice(BigDecimal participationPrice) {
        this.participationPrice = participationPrice;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public String getMaximumDuration() {
        return maximumDuration;
    }

    public void setMaximumDuration(String maximumDuration) {
        this.maximumDuration = maximumDuration;
    }

    public int getMinimumHorseAge() {
        return minimumHorseAge;
    }

    public void setMinimumHorseAge(int minimumHorseAge) {
        this.minimumHorseAge = minimumHorseAge;
    }

    public int getMinimumParticipantAge() {
        return minimumParticipantAge;
    }

    public void setMinimumParticipantAge(int minimumParticipantAge) {
        this.minimumParticipantAge = minimumParticipantAge;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(int currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }
}
