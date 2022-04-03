package ru.job4j.tracker.oop;

public class Cat {
    private String name;
    private String food;

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("this is " + this.name + ", he was eating " + this.food);
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        peppy.eat("cutlet");
        peppy.giveNick("Gav");
        peppy.show();
    }
}
