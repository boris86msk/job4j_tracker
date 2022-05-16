package ru.job4j.tracker.auto;

public class Shinomontaj implements Service {
    private String label;
    private double price;

    public Shinomontaj(String label, double price) {
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
