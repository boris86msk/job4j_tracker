package ru.job4j.tracker.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFnp("Boris Pokidov");
        student.setGroup("Java developer");
        student.setDate("18.03.2022");
        System.out.println(student.getFnp() + ", " + student.getGroup() + ", " + student.getDate());
    }
}
