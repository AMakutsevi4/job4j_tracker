package ru.job4j.polymorphism;

public interface Vehicle extends Fuel {

    void accelerate();

    void brake();

    void steer();

    void changeGear();
}
