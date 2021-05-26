package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void discount(int discount) {
        System.out.println("When choosing " + getClass().getSimpleName() + " discount for next trip: " + discount + " dollars");
    }
}