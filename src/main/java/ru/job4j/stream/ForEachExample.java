package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("One", "Two", "Three");
        strings.stream().map(String::toLowerCase).forEach(System.out::println);
    }
}
