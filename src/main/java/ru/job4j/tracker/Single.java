package ru.job4j.tracker;

import java.util.List;

public class Single {
    private static Single instance = null;

    private Mem mem = new Mem();

    private Single() {
    }

    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

    public Item add(Item item) {
        return mem.add(item);
    }

    public Item findById(int id) {
        return mem.findById(id);
    }

    public List<Item> findAll() {
        return mem.findAll();
    }

    public List<Item> findByName(String keys) {
        return mem.findByName(keys);
    }

    public boolean replase(int id, Item item) {
        return mem.replace(id, item);
    }

    public boolean delete(int id) {
        return mem.delete(id);
    }
}