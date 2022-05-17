package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String department;

    public Surgeon(String name, String surname, String education, int birthday, String specialization, String department) {
        super(name, surname, education, birthday, specialization);
        this.department = department;
    }

    public String diagnosis(boolean cardiogram) {
        if (cardiogram) {
            return "good";
        } else {
            return "bead";
        }
    }
}
