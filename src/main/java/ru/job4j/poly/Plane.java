package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " Перевозит людей быстро на дальние расстояния");
    }
}
