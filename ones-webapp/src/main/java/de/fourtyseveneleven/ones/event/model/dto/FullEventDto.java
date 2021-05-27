package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.common.model.dto.PersonDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class FullEventDto extends SimpleEventDto {

    private PersonDto eventHost;
    private PersonDto eventOrganizer;
    private PersonDto contactPerson;

    private LocalDateTime participationApplicationDeadline;
    private BigDecimal participationApplicationDeadlineMissedFee;

    private boolean isVaccinationMandatory;
    private boolean isHelmetMandatory;

    private List<AccommodationDto> availableAccommodations = new LinkedList<>();

    private List<String> additionalComments;

    public PersonDto getEventHost() {
        return eventHost;
    }

    public void setEventHost(PersonDto eventHost) {
        this.eventHost = eventHost;
    }

    public PersonDto getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(PersonDto eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public PersonDto getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(PersonDto contactPerson) {
        this.contactPerson = contactPerson;
    }

    public LocalDateTime getParticipationApplicationDeadline() {
        return participationApplicationDeadline;
    }

    public void setParticipationApplicationDeadline(LocalDateTime participationApplicationDeadline) {
        this.participationApplicationDeadline = participationApplicationDeadline;
    }

    public BigDecimal getParticipationApplicationDeadlineMissedFee() {
        return participationApplicationDeadlineMissedFee;
    }

    public void setParticipationApplicationDeadlineMissedFee(BigDecimal participationApplicationDeadlineMissedFee) {
        this.participationApplicationDeadlineMissedFee = participationApplicationDeadlineMissedFee;
    }

    public boolean getIsVaccinationMandatory() {
        return isVaccinationMandatory;
    }

    public void setIsVaccinationMandatory(boolean isVaccinationMandatory) {
        this.isVaccinationMandatory = isVaccinationMandatory;
    }

    public boolean getIsHelmetMandatory() {
        return isHelmetMandatory;
    }

    public void setIsHelmetMandatory(boolean isHelmetMandatory) {
        this.isHelmetMandatory = isHelmetMandatory;
    }

    public List<AccommodationDto> getAvailableAccommodations() {
        return availableAccommodations;
    }

    public void setAvailableAccommodations(List<AccommodationDto> availableAccommodations) {
        this.availableAccommodations = availableAccommodations;
    }

    public List<String> getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(List<String> additionalComments) {
        this.additionalComments = additionalComments;
    }
}
