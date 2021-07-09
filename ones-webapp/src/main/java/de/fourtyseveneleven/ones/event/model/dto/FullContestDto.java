package de.fourtyseveneleven.ones.event.model.dto;

import java.time.LocalDateTime;

public class FullContestDto extends SimpleContestDto{

    private LocalDateTime start;

    private String qualificationLevel;

    private boolean isMap;
    private int numberOfStages;

    private Integer minimumHorseAge;
    private Integer maximumHorseAge;

    private Integer minimumParticipantAge;
    private Integer maximumParticipantAge;

    private Integer minimumParticipants;
    private Integer maximumParticipants;
    private Integer currentParticipants;

    private String markings;

    private String signedUpHorses;

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public boolean getIsMap() {
        return isMap;
    }

    public void setIsMap(boolean isMap) {
        this.isMap = isMap;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public Integer getMinimumHorseAge() {
        return minimumHorseAge;
    }

    public void setMinimumHorseAge(Integer minimumHorseAge) {
        this.minimumHorseAge = minimumHorseAge;
    }

    public Integer getMaximumHorseAge() {
        return maximumHorseAge;
    }

    public void setMaximumHorseAge(Integer maximumHorseAge) {
        this.maximumHorseAge = maximumHorseAge;
    }

    public Integer getMinimumParticipantAge() {
        return minimumParticipantAge;
    }

    public void setMinimumParticipantAge(Integer minimumParticipantAge) {
        this.minimumParticipantAge = minimumParticipantAge;
    }

    public Integer getMaximumParticipantAge() {
        return maximumParticipantAge;
    }

    public void setMaximumParticipantAge(Integer maximumParticipantAge) {
        this.maximumParticipantAge = maximumParticipantAge;
    }

    public Integer getMinimumParticipants() {
        return minimumParticipants;
    }

    public void setMinimumParticipants(Integer minimumParticipants) {
        this.minimumParticipants = minimumParticipants;
    }

    public Integer getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(Integer maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    public Integer getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(Integer currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public String getMarkings() {
        return markings;
    }

    public void setMarkings(String markings) {
        this.markings = markings;
    }

    public String getSignedUpHorses() {
        return signedUpHorses;
    }

    public void setSignedUpHorses(String signedUpHorses) {
        this.signedUpHorses = signedUpHorses;
    }
}
