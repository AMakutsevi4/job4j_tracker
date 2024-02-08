package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> resultSkip = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(resultSkip);

        List<String> resultLimit = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(resultLimit);

        List<String> resultSkipAndList = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(resultSkipAndList);

        String findFirstAndOrElse = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(findFirstAndOrElse);

        String findFirstAndOrElseAndGetLastObject = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(findFirstAndOrElseAndGetLastObject);
    }
}