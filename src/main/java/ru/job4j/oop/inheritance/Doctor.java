package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    private String specialization;

    public Doctor(String name, String surname, String education, int birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public String sickLeave(int day) {
        return "Sick leave for " + day + "days";
    }
}
