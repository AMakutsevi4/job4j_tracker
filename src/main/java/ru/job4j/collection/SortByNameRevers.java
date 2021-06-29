package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByNameRevers implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
