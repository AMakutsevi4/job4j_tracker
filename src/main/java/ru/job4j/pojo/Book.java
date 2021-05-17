package ru.job4j.pojo;

public class Book {
    private String name;
    private int page;

    public Book(String name, int count) {
        this.page = count;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}