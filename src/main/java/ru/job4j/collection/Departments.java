package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) { //"k1/sk1");
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());

    }
}