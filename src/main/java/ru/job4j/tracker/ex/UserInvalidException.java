package ru.job4j.tracker.ex;

public class UserInvalidException extends UserNotFoundException {

    public void printStackTrace () {
        System.out.println("user not valid");
    }
}
