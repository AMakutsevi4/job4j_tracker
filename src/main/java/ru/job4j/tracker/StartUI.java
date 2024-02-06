package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Console;
import ru.job4j.tracker.output.Output;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {

        this.out = out;
    }

    public void init(Input input, Store memTracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Выберите: ");
            if (select < 0 || select >= actions.length) {
                out.println("Неправильный ввод, вы можете выбрать: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            if (action.execute(input, memTracker)) {
                run = true;
            } else {
                run = false;
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Меню.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new Console();
        Input input = new Validate(output, new ru.job4j.tracker.input.Console());
        Mem mem = new Mem();
        UserAction[] actions = {
                new Create(output), new Show(output), new Edit(output),
                new Delete(output), new FindId(output), new FindName(output),
                new Exit(), new Profiling()
        };
        new StartUI(output).init(input, mem, actions);
    }
}