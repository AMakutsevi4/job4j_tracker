package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.List;

public class ItemSort {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Alex"),
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Bob"));
        System.out.println(items);
        items.sort(new SortByNameItem());
        System.out.println(items);
        items.sort(new SortByNameRevers());
        System.out.println(items);
    }
}
