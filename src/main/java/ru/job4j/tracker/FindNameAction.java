package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
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
