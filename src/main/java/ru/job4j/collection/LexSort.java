package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        int rsl = Math.min(arrayLeft.length, arrayRight.length);
        for (int i = 0; i < rsl; i++) {
            int leftInt = Integer.parseInt(arrayLeft[i]);
            int rightInt = Integer.parseInt(arrayRight[i]);
            return Integer.compare(leftInt, rightInt);
        }
        return 0;
    }
}
