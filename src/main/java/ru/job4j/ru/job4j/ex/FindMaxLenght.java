package ru.job4j.ru.job4j.ex;

public class FindMaxLenght {

    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon", "Hello", null, "World!"};
        int max = 0;
        for (int index = 0; index < shops.length; index++) {
            String el = shops[index];
            if ((el != null) && (el.length() > max)) {
                max = el.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}