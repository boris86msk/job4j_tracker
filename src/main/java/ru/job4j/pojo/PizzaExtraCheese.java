package ru.job4j.pojo;

public class PizzaExtraCheese extends Pizza {

    @Override
    public String name() {
        return super.name() + " + extra cheese";
    }
}
