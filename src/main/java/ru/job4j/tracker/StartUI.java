package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
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

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

/*
   Метод init объекта tracker реализуется только для класса SqlTracker
   tracker.init(); - вставить первым в try
   Проверить работу классов CreateManyActions и DeleteAllAction
   для SqlTracker()
 */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output,
                new ConsoleInput()
        );
        try (MemTracker tracker = new MemTracker()) {
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new CreateManyActions(output),
                    new EditAction(output),
                    new DeleteAction(output),
                    new DeleteAllAction(output),
                    new ShowAllAction(output),
                    new FindActionById(output),
                    new FindActionByName(output),
                    new ExitAction(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
