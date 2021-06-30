package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] charsLeft = left.toCharArray();
        char[] charsRight = right.toCharArray();
        for (int i = 0; i < Math.min(charsLeft.length, charsRight.length); i++) {
            if (charsLeft[i] != charsRight[i]) {
                return Character.compare(charsLeft[i], charsRight[i]);
            }
        }
        return Integer.compare(charsLeft.length, charsRight.length);
    }
}
