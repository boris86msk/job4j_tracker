package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, ArrayList actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList actions) {
        out.println("Menu:");
        int index = 0;
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions[index].name());
        }
        for (UserAction action : actions) {
            out.println(index + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(output));
                actions.add(new ShowAllAction(output));
                actions.add(new EditAction(output));
                actions.add(new DeleteAction(output));
                actions.add(new FindActionById(output));
                actions.add(new FindActionByName(output));
                actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
    }
}
