package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class CreateManyActions implements UserAction {
    private final Output out;

    public CreateManyActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many Items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        return true;
    }
}
