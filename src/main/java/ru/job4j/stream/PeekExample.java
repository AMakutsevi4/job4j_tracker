package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> stringBuilders = Arrays.asList(
                new StringBuilder("Mikhail"), new StringBuilder("Ivan"), new StringBuilder("Elena"));

        List<StringBuilder> names = stringBuilders.stream().peek((element -> element.append(" (Student Job4j)")))
                .sorted()
                .toList();
        System.out.println(names);
    }
}
