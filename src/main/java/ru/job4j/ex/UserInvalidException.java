package ru.job4j.ex;

public class UserInvalidException extends UserNotFoundException {

    public UserInvalidException() {
        System.out.println("user not valid");
    }
}
