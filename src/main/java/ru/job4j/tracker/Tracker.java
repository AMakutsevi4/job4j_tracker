package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int rsl = 0;
        Item[] itemsName = new Item[size];
        for (int index = 0; index < size; index++) {
            if (key.equals(items[index].getName())) {
                itemsName[rsl++] = items[index];
            }
        }
        return Arrays.copyOf(itemsName, rsl);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
     }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int length = size - index;
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, start, items, size - 1, length);
            items[size - 1] = null;
            size--;
        }
        return true;
    }
}