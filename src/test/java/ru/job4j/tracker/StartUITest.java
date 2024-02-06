package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static java.lang.System.lineSeparator;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "Item name", "1"}
        );
        Mem tracker = new Mem();
        UserAction[] actions = {
                new Create(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new Edit(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new Delete(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = tracker.add(new Item("one request"));
        Item item1 = tracker.add(new Item("two request"));
        Item item2 = tracker.add(new Item("three request"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new Show(out),
                new Exit(),

        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Меню." + lineSeparator()
                + "0. Вывод всех заявок" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()
                + "=== Все заявки: ====" + lineSeparator()
                + item + lineSeparator()
                + item1 + lineSeparator()
                + item2 + lineSeparator()
                + "Меню." + lineSeparator()
                + "0. Вывод всех заявок" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindName(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Меню." + lineSeparator()
                + "0. Вывод заявок по имени" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()
                + "=== Вывод заявок по имени ====" + lineSeparator()
                + item + lineSeparator()
                + "Меню." + lineSeparator()
                + "0. Вывод заявок по имени" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()

        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new Stub();
        Mem tracker = new Mem();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindId(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Меню." + lineSeparator()
                + "0. Вывод заявки по id" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()
                + "=== Вывод заявки по id ====" + lineSeparator()
                + item + lineSeparator()
                + "Меню." + lineSeparator()
                + "0. Вывод заявки по id" + lineSeparator()
                + "1. Выход из программы" + lineSeparator()

        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"123", "0"}
        );
        Mem tracker = new Mem();
        UserAction[] actions = new UserAction[]{
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Меню." + ln
                        + "0. Выход из программы" + ln
                        + "Неправильный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню." + ln
                        + "0. Выход из программы" + ln

                )
        );
    }
}