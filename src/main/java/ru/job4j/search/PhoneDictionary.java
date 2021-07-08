package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> p1 = person -> key.equals(person.getName());
        Predicate<Person> p2 = person -> key.equals(person.getSurname());
        Predicate<Person> p3 = person -> key.equals(person.getPhone());
        Predicate<Person> p4 = person -> key.equals(person.getAddress());
        Predicate<Person> combine = p1.or(p2).or(p3).or(p4);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
