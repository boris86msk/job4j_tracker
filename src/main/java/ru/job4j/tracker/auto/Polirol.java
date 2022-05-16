package ru.job4j.tracker.auto;

public class Polirol extends ServiceDecorator{
    public Polirol(Service service) {
        super(service, "Polirol", 900);
    }
}
