package de.fourtyseveneleven.ones.user.model.dto;

public class PersonalDataDto {

    private String firstName;
    private String lastName;
    private String birthName;

    private String phoneNumber;
    private String phoneNumberMobile;
    private String phoneNumberEmergency;

    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;

    private byte qualificationLevel;

    private String feiNumber;
    private String feNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    public String getPhoneNumberEmergency() {
        return phoneNumberEmergency;
    }

    public void setPhoneNumberEmergency(String phoneNumberEmergency) {
        this.phoneNumberEmergency = phoneNumberEmergency;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public byte getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(byte qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public String getFeiNumber() {
        return feiNumber;
    }

    public void setFeiNumber(String feiNumber) {
        this.feiNumber = feiNumber;
    }

    public String getFeNumber() {
        return feNumber;
    }

    public void setFeNumber(String feNumber) {
        this.feNumber = feNumber;
    }
}
