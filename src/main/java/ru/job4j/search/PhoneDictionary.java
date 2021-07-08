package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = person -> key.contains(person.getName());
        Predicate<Person> surname = person -> key.contains(person.getSurname());
        Predicate<Person> phone = person -> key.contains(person.getPhone());
        Predicate<Person> address = person -> key.contains(person.getAddress());
        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
