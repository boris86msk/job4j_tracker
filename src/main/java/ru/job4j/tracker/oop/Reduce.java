package ru.job4j.tracker.oop;

public class Reduce {
    private int[] array1;

    public void to(int[] array) {
        array1 = array;
    }

    public void print() {
        for (int index = 0; index < array1.length; index++) {
            System.out.println(array1[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
