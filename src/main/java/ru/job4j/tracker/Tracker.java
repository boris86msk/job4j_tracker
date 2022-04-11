package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;
    private java.lang.System System;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            String name = items[i].getName();
            if (key.equals(name)) {
                rsl[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace (int id, Item item) {
        boolean rsl = false;
        Item it = this.findById(id);
        if (it != null) {
            it.setName(item.getName());
            rsl = true;
        }
        return rsl;
    }

    public boolean delete (int id) {
        int index = this.indexOf(id);
        System.arraycopy(this.items, index + 1, this.items, index, size - index -1);
        items[size - 1] = null;
        size--;
        return true;
    }
}