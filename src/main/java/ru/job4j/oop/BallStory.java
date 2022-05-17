package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball boll = new Ball();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Hare hare = new Hare();
        hare.tryEat(boll);
        wolf.tryEat(boll);
        fox.tryEat(boll);
    }
}
