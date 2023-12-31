package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindActionByName;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionByNameTest {

    @Test
    void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item(1, "first_item", LocalDateTime.of(2023, Month.AUGUST, 12, 12, 10)));
        tracker.add(new Item(2, "second_item", LocalDateTime.of(2023, Month.AUGUST, 12, 12, 11)));
        FindActionByName findActionById = new FindActionByName(out);
        String itemView = "Item(id=2, name=second_item, created=2023-08-12T12:11)";

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("second_item");

        findActionById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + itemView + ln);
    }

    @Test
    void wenNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("first_item"));
        tracker.add(new Item("second_item"));
        String name = "item";
        FindActionByName findActionById = new FindActionByName(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);

        findActionById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ==="
                + ln + "Заявки с именем: " + name + " не найдены." + ln);
    }
}