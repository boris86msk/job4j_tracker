package ru.job4j.tracker.ex;

public class UserNotFoundException extends Exception {

    public void printStackTrace() {
        System.out.println("user not found");
    }
}
