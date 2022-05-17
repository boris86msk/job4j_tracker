package ru.job4j.ex;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        System.out.println("user not found");
    }
}
