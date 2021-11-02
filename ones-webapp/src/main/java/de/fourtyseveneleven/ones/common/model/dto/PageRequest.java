package de.fourtyseveneleven.ones.common.model.dto;

import java.util.Objects;

public class PageRequest {

    private int pageNumber;
    private int pageSize;

    public PageRequest(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageRequest that = (PageRequest) o;
        return pageNumber == that.pageNumber && pageSize == that.pageSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize);
    }
}
