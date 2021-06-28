package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSortTest {

    @Test
    public void sortIncrease() {
        List<Item> items = Arrays.asList(new Item("Vasya"),
                new Item("Petr"),
                new Item("Alexander"));
        items.sort(new SortByNameItem());
        assertEquals(items.get(0).getName(), "Alexander");
        assertEquals(items.get(1).getName(), "Petr");
        assertEquals(items.get(2).getName(), "Vasya");
    }

    @Test
    public void sortWaning() {
        List<Item> items = Arrays.asList(new Item("Alexander"),
                new Item("Petr"),
                new Item("Vasya"));
        items.sort(new SortByNameItem().reversed());
        assertEquals(items.get(0).getName(), "Vasya");
        assertEquals(items.get(1).getName(), "Petr");
        assertEquals(items.get(2).getName(), "Alexander");
    }
}