package ru.job4j.stream.certification;

import java.util.List;

public class Pupil {
    /**
     * Класс Pupil описывает ученика
     */
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
