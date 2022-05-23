package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            int symbol = Character.compare(left.charAt(i), right.charAt(i));
            if (symbol != 0) {
                rst = symbol;
                break;
            }
        }
        return rst == 0 ? Integer.compare(left.length(), right.length()) : rst;
    }
}
