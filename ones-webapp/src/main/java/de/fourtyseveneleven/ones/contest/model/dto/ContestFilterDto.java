package de.fourtyseveneleven.ones.contest.model.dto;


import java.time.LocalDateTime;

public class ContestFilterDto {

    private String titleContains;
    private String descriptionContains;
    private LocalDateTime startsBefore;
    private LocalDateTime startsAfter;
    private LocalDateTime endsBefore;
    private LocalDateTime endsAfter;
    private Long organizerId;

    public ContestFilterDto() {}

    public ContestFilterDto(String titleContains, String descriptionContains, LocalDateTime startsBefore,
                            LocalDateTime startsAfter, LocalDateTime endsBefore, LocalDateTime endsAfter,
                            Long organizerId) {
        this.titleContains = titleContains;
        this.descriptionContains = descriptionContains;
        this.startsBefore = startsBefore;
        this.startsAfter = startsAfter;
        this.endsBefore = endsBefore;
        this.endsAfter = endsAfter;
        this.organizerId = organizerId;
    }

    public String getTitleContains() {
        return titleContains;
    }

    public void setTitleContains(String titleContains) {
        this.titleContains = titleContains;
    }

    public String getDescriptionContains() {
        return descriptionContains;
    }

    public void setDescriptionContains(String descriptionContains) {
        this.descriptionContains = descriptionContains;
    }

    public LocalDateTime getStartsBefore() {
        return startsBefore;
    }

    public void setStartsBefore(LocalDateTime startsBefore) {
        this.startsBefore = startsBefore;
    }

    public LocalDateTime getStartsAfter() {
        return startsAfter;
    }

    public void setStartsAfter(LocalDateTime startsAfter) {
        this.startsAfter = startsAfter;
    }

    public LocalDateTime getEndsBefore() {
        return endsBefore;
    }

    public void setEndsBefore(LocalDateTime endsBefore) {
        this.endsBefore = endsBefore;
    }

    public LocalDateTime getEndsAfter() {
        return endsAfter;
    }

    public void setEndsAfter(LocalDateTime endsAfter) {
        this.endsAfter = endsAfter;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }
}
