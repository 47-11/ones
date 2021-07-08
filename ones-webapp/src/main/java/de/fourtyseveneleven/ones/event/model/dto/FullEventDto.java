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
    private FeeDto signupChangeFee;
    private String vaccinationInformation;
    private String helmetInformation;

    private List<AccommodationDto> availableAccommodations = new LinkedList<>();

    private List<String> additionalComments;

    private String organizerWebsiteUrl;
    private String signupDocumentUrl;

    private int minimumParticipants;
    private int maximumParticipants;
    private int currentParticipants;

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

    public FeeDto getSignupChangeFee() {
        return signupChangeFee;
    }

    public void setSignupChangeFee(FeeDto signupChangeFee) {
        this.signupChangeFee = signupChangeFee;
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

    public int getMinimumParticipants() {
        return minimumParticipants;
    }

    public void setMinimumParticipants(int minimumParticipants) {
        this.minimumParticipants = minimumParticipants;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(int currentParticipants) {
        this.currentParticipants = currentParticipants;
    }
}
