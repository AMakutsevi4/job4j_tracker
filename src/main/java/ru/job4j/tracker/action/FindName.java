package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

import java.util.List;

public class FindName implements UserAction {
    private final Output out;

    public FindName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Вывод заявок по имени";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Вывод заявок по имени ====");
        String name = input.askStr("Введите имя: ");
        List<Item> items = memTracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки не найдены.");
        }
        return true;
    }
}
