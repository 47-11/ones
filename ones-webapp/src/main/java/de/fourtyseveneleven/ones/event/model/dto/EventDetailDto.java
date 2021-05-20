package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.event.model.RideType;

import java.util.Set;

public class EventDetailDto {

    private EventDto event;
    private AddressDto address;

    private String participationDocumentUrl;
    private String tenderDocumentUrl;

    private String mdr;
    private String ldr;
    private String mtr;
    private Set<RideType> rideTypes;
    private String additionalRideInformation;

    private String eventInitiatorName;
    private AddressDto eventInitiatorAddress;

    private String organizerName;
    private AddressDto organizerAddress;

    private String contactPersonName;
    private AddressDto contactPersonAddress;
    private String contactPhoneNumber;
    private String contactEmailAddress;

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(EventDto event) {
        this.event = event;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getParticipationDocumentUrl() {
        return participationDocumentUrl;
    }

    public void setParticipationDocumentUrl(String participationDocumentUrl) {
        this.participationDocumentUrl = participationDocumentUrl;
    }

    public String getTenderDocumentUrl() {
        return tenderDocumentUrl;
    }

    public void setTenderDocumentUrl(String tenderDocumentUrl) {
        this.tenderDocumentUrl = tenderDocumentUrl;
    }

    public String getMdr() {
        return mdr;
    }

    public void setMdr(String mdr) {
        this.mdr = mdr;
    }

    public String getLdr() {
        return ldr;
    }

    public void setLdr(String ldr) {
        this.ldr = ldr;
    }

    public String getMtr() {
        return mtr;
    }

    public void setMtr(String mtr) {
        this.mtr = mtr;
    }

    public Set<RideType> getRideTypes() {
        return rideTypes;
    }

    public void setRideTypes(Set<RideType> rideTypes) {
        this.rideTypes = rideTypes;
    }

    public String getAdditionalRideInformation() {
        return additionalRideInformation;
    }

    public void setAdditionalRideInformation(String additionalRideInformation) {
        this.additionalRideInformation = additionalRideInformation;
    }

    public String getEventInitiatorName() {
        return eventInitiatorName;
    }

    public void setEventInitiatorName(String eventInitiatorName) {
        this.eventInitiatorName = eventInitiatorName;
    }

    public AddressDto getEventInitiatorAddress() {
        return eventInitiatorAddress;
    }

    public void setEventInitiatorAddress(AddressDto eventInitiatorAddress) {
        this.eventInitiatorAddress = eventInitiatorAddress;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public AddressDto getOrganizerAddress() {
        return organizerAddress;
    }

    public void setOrganizerAddress(AddressDto organizerAddress) {
        this.organizerAddress = organizerAddress;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public AddressDto getContactPersonAddress() {
        return contactPersonAddress;
    }

    public void setContactPersonAddress(AddressDto contactPersonAddress) {
        this.contactPersonAddress = contactPersonAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactEmailAddress() {
        return contactEmailAddress;
    }

    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }
}
