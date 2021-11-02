package de.fourtyseveneleven.ones.common.model.dto;

import de.fourtyseveneleven.ones.common.model.SortDirection;

import java.util.Objects;

public class SortRequest {

    private String attributeName;
    private SortDirection sortDirection;

    public SortRequest(String attributeName, SortDirection sortDirection) {
        this.attributeName = attributeName;
        this.sortDirection = sortDirection;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SortRequest that = (SortRequest) o;
        return Objects.equals(attributeName, that.attributeName) && sortDirection == that.sortDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, sortDirection);
    }
}
