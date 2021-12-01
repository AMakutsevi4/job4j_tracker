package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
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
