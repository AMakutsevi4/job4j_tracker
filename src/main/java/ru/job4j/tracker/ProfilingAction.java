package ru.job4j.tracker;

import static java.lang.System.out;

public class ProfilingAction implements UserAction {

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
