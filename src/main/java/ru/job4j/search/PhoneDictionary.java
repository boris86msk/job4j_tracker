package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> contName = (t) -> t.getName().contains(key);
        Predicate<Person> contSurname = (t) -> t.getSurname().contains(key);
        Predicate<Person> contPhone = (t) -> t.getPhone().contains(key);
        Predicate<Person> contAddress = (t) -> t.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (contName.or(contSurname)
                    .or(contPhone).or(contAddress).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
