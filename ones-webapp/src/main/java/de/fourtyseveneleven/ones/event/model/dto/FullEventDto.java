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
    private boolean signupAfterDeadlinePossible;
    private FeeDto lateSignupFee;
    private String vaccinationInformation;
    private String helmetInformation;

    private List<AccommodationDto> availableAccommodations = new LinkedList<>();

    private List<String> additionalComments;

    private String organizerWebsiteUrl;
    private String signupDocumentUrl;

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

    public boolean isSignupAfterDeadlinePossible() {
        return signupAfterDeadlinePossible;
    }

    public void setSignupAfterDeadlinePossible(boolean signupAfterDeadlinePossible) {
        this.signupAfterDeadlinePossible = signupAfterDeadlinePossible;
    }

    public LocalDateTime getSignupDeadline() {
        return signupDeadline;
    }

    public void setSignupDeadline(LocalDateTime signupDeadline) {
        this.signupDeadline = signupDeadline;
    }

    public FeeDto getLateSignupFee() {
        return lateSignupFee;
    }

    public void setLateSignupFee(FeeDto lateSignupFee) {
        this.lateSignupFee = lateSignupFee;
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

    public String getOrganizerWebsiteUrl() {
        return organizerWebsiteUrl;
    }

    public void setOrganizerWebsiteUrl(String organizerWebsiteUrl) {
        this.organizerWebsiteUrl = organizerWebsiteUrl;
    }

    public String getSignupDocumentUrl() {
        return signupDocumentUrl;
    }

    public void setSignupDocumentUrl(String signupDocumentUrl) {
        this.signupDocumentUrl = signupDocumentUrl;
    }
}
