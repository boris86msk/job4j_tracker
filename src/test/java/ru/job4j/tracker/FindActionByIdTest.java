package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindActionById;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionByIdTest {

    @Test
    void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item(1, "test_item", LocalDateTime.of(2023, Month.AUGUST, 12, 12, 00)));
        tracker.add(new Item(2, "test_item", LocalDateTime.of(2023, Month.AUGUST, 12, 12, 01)));
        FindActionById findActionById = new FindActionById(out);
        String itemView = "Item(id=1, name=test_item, created=2023-08-12T12:00)";

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        findActionById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + itemView + ln);
    }

    @Test
    void wenNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("test_item1"));
        tracker.add(new Item("test_item2"));
        FindActionById findActionById = new FindActionById(out);
        int id = 3;

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(id);

        findActionById.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ==="
                + ln + "Заявка с введенным id: " + id + " не найдена." + ln);
    }
}