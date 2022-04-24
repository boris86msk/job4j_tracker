package ru.job4j.tracker.ex;

public class UserInvalidException extends UserNotFoundException {

    public UserInvalidException() {
        System.out.println("user not valid");
    }
}
