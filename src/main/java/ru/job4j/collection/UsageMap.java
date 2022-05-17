package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("ivan@gmail.ru", "Ivanov Ivan Ivanch");
        mail.put("sergey@mail.ru", "Good Sergey Vasilich");
        mail.put("boris@yandex.ru", "Pokidov Boris Yurevich");
        for (String key : mail.keySet()) {
            String value = mail.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
