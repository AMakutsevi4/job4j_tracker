package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void discount(int discount) {
        System.out.println("When choosing " + getClass().getSimpleName()
                + " discount for next trip: " + discount + " dollars");
    }
}