package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                new Item("C++", 1),
                new Item("Java", 2),
                new Item("Lua", 3),
                new Item("Phyton", 4)
        );
        System.out.println(items);
        Collections.sort(items, new ItemAscByName());
        System.out.println(items);
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
                new Item("Phyton", 1),
                new Item("Lua", 2),
                new Item("Java", 3),
                new Item("C++", 4)
        );
        System.out.println(items);
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
    }
}