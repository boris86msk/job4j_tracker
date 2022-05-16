package ru.job4j.tracker.auto;

public class Run {
    public static void main(String[] args) {
        Service shinomontaj = new Shinomontaj("shinomontaj", 300);
        Service moyka = new Moyka(shinomontaj);
        Service polirol = new Polirol(moyka);
        System.out.println(moyka.getPrice());
    }
}
