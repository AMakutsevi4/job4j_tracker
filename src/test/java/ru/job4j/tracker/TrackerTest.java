package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Mem tracker = new Mem();
        Item item = new Item("test1");
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Mem tracker = new Mem();
        Item bug = new Item("name", 1);
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("name", 1);
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Mem tracker = new Mem();
        Item bug = new Item("name", 1);
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        String nullTest = null;
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullTest));
    }
}