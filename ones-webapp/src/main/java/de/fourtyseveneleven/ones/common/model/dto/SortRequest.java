package de.fourtyseveneleven.ones.common.model.dto;

import de.fourtyseveneleven.ones.common.model.SortDirection;

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
}
