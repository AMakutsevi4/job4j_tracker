package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Выход из программы";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        return false;
    }
}
