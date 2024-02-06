package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

import java.util.List;

public class Show implements UserAction {
    private final Output out;

    public Show(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Вывод всех заявок";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Все заявки: ====");
        List<Item> items = memTracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
