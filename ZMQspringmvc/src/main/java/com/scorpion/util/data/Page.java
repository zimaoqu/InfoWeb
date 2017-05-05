package com.scorpion.util.data;

/**
 * Created by Scorpion on 2017/3/20.
 */
import java.util.List;

public class Page<T> {

    private List<T> content;
    private int totalRecords;
    private int totalPages;

    public Page(List<T> content, int totalRecords, int pageSize) {
        this.content = content;
        this.totalRecords = totalRecords;
        this.totalPages = this.calculatePages(pageSize, totalRecords);
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    private int calculatePages(int pageSize, int totalRecords) {
        return (totalRecords+pageSize-1) / pageSize;
    }

}
