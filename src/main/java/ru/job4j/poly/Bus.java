package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Количество пассажиров: " + quantity);
    }

    @Override
    public double price(int quantity) {
        double price = 44.70;
        return price * quantity;
    }
}
