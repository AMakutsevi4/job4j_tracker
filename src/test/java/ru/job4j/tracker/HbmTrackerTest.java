package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

class HbmTrackerTest {

    @Test
    void whenAdd() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item();
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }

    @Test
    void whenFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll(), is(List.of(item1, item2)));
    }

    @Test
    void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("item1").get(0).getName(), is(item1.getName()));
        assertThat(tracker.findByName("item2").get(0).getName(), is(item2.getName()));
    }
}