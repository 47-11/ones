package de.fourtyseveneleven.ones.contest.model.dto;

public class ContestDetailDto {

    private ContestDto contest;
    private String description;
    private String organizerName;
    private String contactInformation;

    public ContestDto getContest() {
        return contest;
    }

    public void setContest(ContestDto contest) {
        this.contest = contest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
