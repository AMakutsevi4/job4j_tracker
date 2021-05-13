package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item(int id) {

    }

    public Item() {

    }

    public Item(String name) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Item one = new Item();
    Item two = new Item(1);
    Item three = new Item("Stop1");

}
