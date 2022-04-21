package ru.job4j.tracker.ex;

public class ElementNotFoundException extends Exception{
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException();
        }
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] str = {"one", "two", "three"};
            indexOf(str, "");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
