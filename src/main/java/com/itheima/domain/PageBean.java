package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
    private int pageSize;
    private int currentPage;
    private List<T> objectList;
    private int totalPage;
    private int totalCount;
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", objectList=" + objectList +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
