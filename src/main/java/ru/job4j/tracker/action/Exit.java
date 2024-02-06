package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Store;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Выход из программы";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        return false;
    }
}
