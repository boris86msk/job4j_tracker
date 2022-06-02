package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String a = first.split("/")[0];
        String b = second.split("/")[0];
        return a.equals(b) ? first.compareTo(second) : second.compareTo(first);

    }
}