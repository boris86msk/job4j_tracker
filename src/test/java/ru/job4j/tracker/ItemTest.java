package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemTest {
    @Test
    public void testItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Java", 1),
                new Item("Phyton", 2),
                new Item("C++", 3),
                new Item("Lua", 4)
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item("C++", 3),
                new Item("Java", 1),
                new Item("Lua", 4),
                new Item("Phyton", 2)
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(itemsExpected));
    }

    @Test
    public void testItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Java", 1),
                new Item("Phyton", 2),
                new Item("C++", 3),
                new Item("Lua", 4)
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item("Phyton", 2),
                new Item("Lua", 4),
                new Item("Java", 1),
                new Item("C++", 3)
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(itemsExpected));
    }
}