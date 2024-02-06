package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import static java.lang.System.out;

public class Profiling implements UserAction {

    @Override
    public String name() {
        return "Анализ состояния памяти";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        for (int i = 0; i < 1_000_000; i++) {
            Item item = new Item(i);
            item.setName("item " + i);
            memTracker.add(item);
            memTracker.delete(i);
            out.println(memTracker.findById(i));
        }
        return true;
    }
}
