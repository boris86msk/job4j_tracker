package ru.job4j.tracker.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator mult = new Calculator();
        result = mult.multiply(10);
        System.out.println(result);
        result = minus(15);
        System.out.println(result);
        result = mult.divide(25);
        System.out.println(result);
        result = mult.sumAllOperation(20);
        System.out.println(result);
    }
}
