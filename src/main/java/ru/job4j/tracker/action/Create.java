package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Store;

public class Create implements UserAction {
    private final Output out;

    public Create(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Добавление заявки";
    }

    @Override
    public boolean execute(Input input, Store nemTracker) {
        out.println("=== Добавление заявки ====");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        nemTracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
