package ru.job4j.tracker.ex;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        System.out.println("user not found");
    }
}
