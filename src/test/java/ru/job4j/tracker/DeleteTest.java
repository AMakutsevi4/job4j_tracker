package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.Delete;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteTest {

    @Test
    public void whenDeleteTrue() {
        Output out = new Stub();
        Mem tracker = new Mem();
        tracker.add(new Item("Удаление заявки."));
        Delete delete = new Delete(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        assertThat(out.toString(), is("=== Удаление заявки ===="
                + System.lineSeparator()
                + "Заявка удалена успешно."
                + System.lineSeparator()));
     }

    @Test
    public void whenDeleteNotCompleted() {
        Output out = new Stub();
        Mem tracker = new Mem();
        tracker.add(new Item("Удаление заявки"));
        Delete delete = new Delete(out);
        Input input = mock(Input.class);
        delete.execute(input, tracker);
        assertThat(out.toString(), is("=== Удаление заявки ===="
                + System.lineSeparator()
                + "Ошибка удаления заявки."
                + System.lineSeparator()));
        assertThat(tracker.findAll().get(0).getName(), is("Удаление заявки"));
    }

}