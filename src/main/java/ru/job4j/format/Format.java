package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name) {
        System.out.println(String.format("Привет! Я %s", name));
    }

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет! Я %s", name));
        System.out.println(String.format("Привет! Я %s, мой возраст: %d", name, age));
        System.out.println(String.format("Аргумент передан? %b", age));
        System.out.println(String.format("Задаем число 0.99 - %f", 0.99));
        System.out.println(String.format("Задаем число 0.99 - %.2f", 0.99));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Елена");
        getGreeting("Lena", 18);
        getGreetingAndTime("Lena");
    }

}

