package ru.job4j.checkstyle;

public class Broken {

    private final String newValue = "";
    private String surname;
    private String name;
    private int sizeOfEmpty = 10;

    public Broken() {
    }

    public void echo() {
    }

    public void method(int a, int b, int c, int d) {

    }

    public void methodTwo(int e, int f, int g, int h) {

    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }
}
