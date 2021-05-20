package de.fourtyseveneleven.ones.contest.model.dto;

import de.fourtyseveneleven.ones.rider.model.dto.RiderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ContestDto {

    private long id;
    private int version;
    private LocalDateTime created;
    private LocalDateTime lastModified;

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    /**
     *  In km
     */
    private BigDecimal distance;

    private RiderDto organizer;

    public ContestDto() {
    }

    public ContestDto(long id) {
        this.id = id;
    }

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

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public RiderDto getOrganizer() {
        return organizer;
    }

    public void setOrganizer(RiderDto organizer) {
        this.organizer = organizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContestDto that = (ContestDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
