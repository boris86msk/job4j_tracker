package ru.job4j.pojo;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    @Override
    public String name() {
        return super.name() + " + extra tomato";
    }
}
