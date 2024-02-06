package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.FindId;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FindIdTest {

    @Test
    public void whenFindByIdTrue() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = new Item("Вывод заявки по id");
        tracker.add(item);
        int findId = item.getId();
        FindId action = new FindId(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Вывод заявки по id ===="
                + System.lineSeparator()
                + item + System.lineSeparator()));
        assertThat(tracker.findById(findId), is(item));
    }

    @Test
    public void whenFindByIdFalse() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = new Item("Вывод заявки по id");
        tracker.add(item);
        int findId = item.getId();
        FindId action = new FindId(out);
        Input input = mock(Input.class);
        action.execute(input, tracker);
        assertThat(out.toString(), is("=== Вывод заявки по id ===="
                + System.lineSeparator()
                + "Заявка с введенным id: 0 не найдена."
                + System.lineSeparator()));
        assertThat(tracker.findById(findId), is(item));
    }
}