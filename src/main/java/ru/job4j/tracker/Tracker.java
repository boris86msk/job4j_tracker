package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            String name = i.getName();
            if (key.equals(name)) {
                rsl.add(i);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
            int index = this.indexOf(id);
            boolean rsl = index != -1;
            if (rsl) {
                items.remove(index);
            }
            return rsl;
    }
}