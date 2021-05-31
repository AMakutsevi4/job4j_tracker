package ru.job4j.ru.job4j.ex;

public class FindMaxLenght {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String el : shops) {
            if (el != null) {
                max++;
            }
        }
        System.out.println("Max length : " + max);
    }
}
