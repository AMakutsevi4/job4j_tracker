package ru.job4j.polymorphism;

public interface FunctionTwo extends FunctionOne {

    default double function(double x, double y) {
        return x * x - y + 5;
    }

    default void functionMessage() {
        System.out.println("Сообщение из FunctionOne");
    }
}
