package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

public class Edit implements UserAction {
    private final Output out;

    public Edit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Изменение заявки";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Изменение заявки ====");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (memTracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
