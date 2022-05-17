package ru.job4j.tracker.oop.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, int birthday, String branch, String language) {
        super(name, surname, education, birthday, branch);
        this.language = language;
    }

    public String code() {
        return "Hello world!";
    }
}
