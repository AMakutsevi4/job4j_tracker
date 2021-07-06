package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        String[] numbers = {
                "Petr",
                "Alexander",
                "Vasya"
        };
        Comparator<String> compText = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return left.compareTo(right);

        };

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(numbers, compText);
        Arrays.sort(numbers, cmpDescSize);
    }

}
