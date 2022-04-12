package ru.job4j.tracker.poly;

public interface Transport {
    void drive();

    void  passengers(int quantity);

    double price(int quantity);
}
