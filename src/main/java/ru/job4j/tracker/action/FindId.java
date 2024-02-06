package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

public class FindId implements UserAction {
    private final Output out;

    public FindId(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Вывод заявки по id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Вывод заявки по id ====");
        int id = input.askInt("Введите id: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
