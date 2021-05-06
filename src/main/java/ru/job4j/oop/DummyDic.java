package ru.job4j.oop;

public class DummyDic {
    public String engTORus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic alex = new DummyDic();
        String word = alex.engTORus("woop");
        System.out.println(word);
    }
}