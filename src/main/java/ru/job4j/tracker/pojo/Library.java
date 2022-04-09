package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("War and peace", 1300);
        Book book2 = new Book("Clean code", 500);
        Book book3 = new Book("fathers and children", 300);
        Book book4 = new Book("Ruslan and Lyudmila", 250);
        Book[] lib = new Book[4];
        lib[0] = book1;
        lib[1] = book2;
        lib[2] = book3;
        lib[3] = book4;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName() + " : " + lib[i].getPages() + " pages.");
        }
        Book inf = lib[0];
        lib[0] = lib[3];
        lib[3] = inf;
        System.out.println();
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName() + " : " + lib[i].getPages() + " pages.");
        }
        System.out.println();
        for (int i = 0; i < lib.length; i++) {
            if ("Clean code".equals(lib[i].getName())) {
                System.out.println(lib[i].getName() + " : " + lib[i].getPages() + " pages.");
            }
        }
    }
}
