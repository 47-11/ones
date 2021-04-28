package de.fourtyseveneleven.ones.contest.model.dto;

import de.fourtyseveneleven.ones.rider.model.dto.RiderDto;

import java.time.LocalDateTime;

public class ContestDto {

    private long id;
    private int version;
    private LocalDateTime created;
    private LocalDateTime lastModified;

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    private RiderDto organizer;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public RiderDto getOrganizer() {
        return organizer;
    }

    public void setOrganizer(RiderDto organizer) {
        this.organizer = organizer;
    }
}
