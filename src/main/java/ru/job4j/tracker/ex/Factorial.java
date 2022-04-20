package ru.job4j.tracker.ex;

public class Factorial {
    public int calc(int n) {
        if (n < 0) {
          throw new IllegalArgumentException("N could not be less then 0");
        }
        int rsl = 1;
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        new Factorial().calc(-1);
    }
}
