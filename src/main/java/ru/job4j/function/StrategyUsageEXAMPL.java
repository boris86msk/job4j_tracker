package ru.job4j.function;

import java.util.function.Predicate;

public class StrategyUsageEXAMPL {
    public boolean empty(String s) {
        return check(str -> str.isEmpty(), s);
    }

    public boolean startWith(String s, String pref) {
        return check(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return check(str -> str.contains(key), s);
    }

    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    public static void main(String[] args) {
        StrategyUsageEXAMPL usage = new StrategyUsageEXAMPL();
        System.out.println("Результат работы: " + usage.check(str -> str.isEmpty(), ""));

        System.out.println("Результат работы: " + usage.check(str -> str.startsWith("Fun"),
                "Functional interface"));

        System.out.println("Результат работы: " + usage.check(str -> str.contains("rn"),
                "Surname Name"));
    }
}
