package ru.job4j.stream.mapto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapToIntExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );

        int sum = people.stream()
                .filter(person -> person.getAge() > 25)
                .mapToInt(Person::getAge)
                .peek(System.out::println)
                .sum();
        System.out.println("Сумма: " + sum);

        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};
        List<Integer> list = Stream.of(array1, array2, array3)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
