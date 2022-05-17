package ru.job4j.auto;

public class Polirol extends ServiceDecorator {
    public Polirol(Service service) {
        super(service, "Polirol", 900);
    }
}
