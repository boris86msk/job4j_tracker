package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus09 = new Bus09();
        Vehicle bus15 = new Bus09();
        Vehicle train758 = new Train();
        Vehicle train759 = new Train();
        Vehicle j7 = new Plane();
        Vehicle aeroflot = new Plane();

        Vehicle[] vehicles = new Vehicle[]{bus09, bus15, train758, train759, j7, aeroflot};
        for (Vehicle i : vehicles) {
            i.move();
        }
    }
}
