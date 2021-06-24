package de.fourtyseveneleven.ones.event.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FullContestDto extends SimpleContestDto{

    private LocalDateTime start;
    private boolean canStartLater;

    /**
     * In m
     */
    private BigDecimal altitudeDifference;

    private Integer qualificationLevel;

    private BigDecimal signupFee;
    private BigDecimal startFee;

    private String maximumDuration;

    private int minimumHorseAge;
    private int minimumParticipantAge;

    private int currentParticipants;
    private int maximumParticipants;

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public boolean isCanStartLater() {
        return canStartLater;
    }

    public void setCanStartLater(boolean canStartLater) {
        this.canStartLater = canStartLater;
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

    public BigDecimal getSignupFee() {
        return signupFee;
    }

    public void setSignupFee(BigDecimal signupFee) {
        this.signupFee = signupFee;
    }

    public BigDecimal getStartFee() {
        return startFee;
    }

    public void setStartFee(BigDecimal startFee) {
        this.startFee = startFee;
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
