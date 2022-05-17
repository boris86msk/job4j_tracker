package ru.job4j.auto;

public class Moyka extends ServiceDecorator {

    public Moyka(Service service) {
        super(service, "Moyka", 500);
    }
}
