package de.fourtyseveneleven.ones.user.model.dto;

import de.fourtyseveneleven.ones.common.model.dto.PersonDto;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto extends PersonDto {

    private UUID uuid;

    private String vddNumber;
    private String feiNumber;
    private String fnNumber;

    private String qualificationLevel;
    private boolean qualificationLevelApproved;

    private String phoneNumberEmergency;

    private String birthName;
    private LocalDate birthday;

    public UserDto() {
    }

    public UserDto(String emailAddress) {
        super(emailAddress);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getVddNumber() {
        return vddNumber;
    }

    public void setVddNumber(String vddNumber) {
        this.vddNumber = vddNumber;
    }

    public String getFeiNumber() {
        return feiNumber;
    }

    public void setFeiNumber(String feiNumber) {
        this.feiNumber = feiNumber;
    }

    public String getFnNumber() {
        return fnNumber;
    }

    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public boolean isQualificationLevelApproved() {
        return qualificationLevelApproved;
    }

    public void setQualificationLevelApproved(boolean qualificationLevelApproved) {
        this.qualificationLevelApproved = qualificationLevelApproved;
    }

    public String getPhoneNumberEmergency() {
        return phoneNumberEmergency;
    }

    public void setPhoneNumberEmergency(String phoneNumberEmergency) {
        this.phoneNumberEmergency = phoneNumberEmergency;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
