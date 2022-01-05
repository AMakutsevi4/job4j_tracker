package ru.job4j.tracker;

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
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output), new ShowAction(output), new EditAction(output),
                new DeleteAction(output), new FindIdAction(output), new FindNameAction(output),
                new ExitAction(), new ProfilingAction()
        };
        new StartUI(output).init(input, memTracker, actions);
    }
}