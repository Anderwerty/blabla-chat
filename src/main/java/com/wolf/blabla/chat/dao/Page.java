package com.wolf.blabla.chat.dao;

public class Page {
    private int pageNumber;
    private int number;

    public Page(int pageNumber, int number) {
        this.pageNumber = pageNumber;
        this.number = number;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getNumber() {
        return number;
    }
}
