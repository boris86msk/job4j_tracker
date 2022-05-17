package ru.job4j.tracker.poly;

public class Bus09 implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " Перевозит много людей на короткие расстояния");
    }
}
