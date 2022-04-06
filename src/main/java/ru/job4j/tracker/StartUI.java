package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Item timeNow = new Item();
        System.out.println(timeNow.getTime("dd-MMMM-EEEE-yyyy HH:mm:ss"));
    }
}
