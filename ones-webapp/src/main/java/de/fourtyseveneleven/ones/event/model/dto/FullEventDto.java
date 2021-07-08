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

    private LocalDateTime signupDeadline;
    private BigDecimal signupDeadlineMissedFee;

    private String vaccinationInformation;
    private String helmetInformation;

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

    public LocalDateTime getSignupDeadline() {
        return signupDeadline;
    }

    public void setSignupDeadline(LocalDateTime signupDeadline) {
        this.signupDeadline = signupDeadline;
    }

    public BigDecimal getSignupDeadlineMissedFee() {
        return signupDeadlineMissedFee;
    }

    public void setSignupDeadlineMissedFee(BigDecimal signupDeadlineMissedFee) {
        this.signupDeadlineMissedFee = signupDeadlineMissedFee;
    }

    public String getVaccinationInformation() {
        return vaccinationInformation;
    }

    public void setVaccinationInformation(String vaccinationInformation) {
        this.vaccinationInformation = vaccinationInformation;
    }

    public String getHelmetInformation() {
        return helmetInformation;
    }

    public void setHelmetInformation(String helmetInformation) {
        this.helmetInformation = helmetInformation;
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
