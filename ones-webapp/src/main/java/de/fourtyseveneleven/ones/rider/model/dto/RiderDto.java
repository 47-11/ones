package de.fourtyseveneleven.ones.rider.model.dto;

import java.time.LocalDateTime;

public class RiderDto {

    private long id;
    private int version;
    private LocalDateTime created;
    private LocalDateTime lastModified;

    private String emailAddress;
    private String firstName;
    private String lastName;

    private boolean initialDataSetupCompleted = true;
    private boolean allNecessaryDataPresent = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

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

    public boolean isInitialDataSetupCompleted() {
        return initialDataSetupCompleted;
    }

    public void setInitialDataSetupCompleted(boolean initialDataSetupCompleted) {
        this.initialDataSetupCompleted = initialDataSetupCompleted;
    }

    public boolean isAllNecessaryDataPresent() {
        return allNecessaryDataPresent;
    }

    public void setAllNecessaryDataPresent(boolean allNecessaryDataPresent) {
        this.allNecessaryDataPresent = allNecessaryDataPresent;
    }
}