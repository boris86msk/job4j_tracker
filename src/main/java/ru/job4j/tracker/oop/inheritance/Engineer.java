package ru.job4j.tracker.oop.inheritance;

public class Engineer extends Profession {
    private String branch;

    public Engineer(String name, String surname, String education, int birthday, String branch) {
        super(name, surname, education, birthday);
        this.branch = branch;
    }

    public String proоect() {
        return "New project";
    }
}
