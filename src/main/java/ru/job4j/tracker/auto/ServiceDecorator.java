package ru.job4j.tracker.auto;

public class ServiceDecorator implements Service{

    private Service service;
    private String label;
    private double price;

    public ServiceDecorator(Service service, String label, double price) {
        this.service = service;
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price + service.getPrice();
    }

    public String getLabel() {
        return this.label + service.getLabel();
    }

}
