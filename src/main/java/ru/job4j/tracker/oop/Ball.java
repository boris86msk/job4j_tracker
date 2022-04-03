package ru.job4j.tracker.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("kolobok was eaten");
        } else {
            System.out.println("kolobok escaped");
        }
    }
}
