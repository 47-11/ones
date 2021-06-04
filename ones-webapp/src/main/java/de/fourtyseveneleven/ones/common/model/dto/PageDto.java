package de.fourtyseveneleven.ones.common.model.dto;

import java.util.LinkedList;
import java.util.List;

public class PageDto<T> {

    private List<T> elements = new LinkedList<>();

    private int pageNumber;
    private int pageSize;
    private int totalElements;

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
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

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
