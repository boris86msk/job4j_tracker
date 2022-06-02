package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String dep : deps) {
            String start = "";
            for (String el : dep.split("/")) {
                if (el.length() < 3) {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
