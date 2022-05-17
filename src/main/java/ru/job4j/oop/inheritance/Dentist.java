package ru.job4j.tracker.oop.inheritance;

public class Dentist extends Doctor {
    private String ageGroup;

    public Dentist(String name, String surname, String education, int birthday, String specialization, String ageGroup) {
        super(name, surname, education, birthday, specialization);
        this.ageGroup = ageGroup;
    }

    public String appointment(String date) {
        return "you are booked for" + date;
    }
}
