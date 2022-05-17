package ru.job4j.auto;

public class Balans implements Service {

    private String label;
    private double price;

    public Balans(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getLabel() {
        return this.label;
    }
}
