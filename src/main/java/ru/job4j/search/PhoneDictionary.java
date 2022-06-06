package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> comb = (t) -> t.getName().contains(key);
        Predicate<Person> comb2 = (t) -> t.getSurname().contains(key);
        Predicate<Person> comb3 = (t) -> t.getPhone().contains(key);
        Predicate<Person> comb4 = (t) -> t.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (comb.or(comb2).or(comb3).or(comb4).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
