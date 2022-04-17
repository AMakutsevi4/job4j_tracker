package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteActionTest {

    @Test
    public void whenDeleteTrue() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Удаление заявки."));
        DeleteAction delete = new DeleteAction(out);
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
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Удаление заявки"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        delete.execute(input, tracker);
        assertThat(out.toString(), is("=== Удаление заявки ===="
                + System.lineSeparator()
                + "Ошибка удаления заявки."
                + System.lineSeparator()));
        assertThat(tracker.findAll().get(0).getName(), is("Удаление заявки"));
    }

}