package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String[] o1 = first.split("/");
        String[] o2 = second.split("/");
        int rsl = o1[0].compareTo(o2[0]);
        return (rsl != 0 ? second.compareTo(first) : first.compareTo(second));
    }
}