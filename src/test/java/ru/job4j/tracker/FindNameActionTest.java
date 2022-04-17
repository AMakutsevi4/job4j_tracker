package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FindNameActionTest {

    @Test
    public void whenFindByNameTrue() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Вывод заявок по имени");
        tracker.add(item);
        String findName = item.getName();
        FindNameAction action = new FindNameAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(findName);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Вывод заявок по имени ====" + System.lineSeparator()
                + item
                + System.lineSeparator()));
        assertThat(tracker.findByName(findName), is(List.of(item)));
    }

    @Test
    public void whenFindByNameFalse() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Вывод заявок по имени");
        tracker.add(item);
        String findName = item.getName();
        FindNameAction action = new FindNameAction(out);
        Input input = mock(Input.class);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Вывод заявок по имени ===="
                + System.lineSeparator()
                + "Заявки не найдены."
                + System.lineSeparator()));
        assertThat(tracker.findByName(findName), is(List.of(item)));
    }

}