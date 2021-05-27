package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        int id = item.getId();
        item.setName("replaced item");
        assertThat(tracker.findById(id).getName(), is("replaced item"));
    }

    @Test
    public void whenReplaceItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("null");
        tracker.add(item);
        int id = item.getId();
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            assertThat(tracker.delete(id), is("null"));
        }
    }
}