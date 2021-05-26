package ru.job4j.oop;

public class UsageVehicle {
    public static void main(String[] args) {
        Vehicle air = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[]{air, bus, train};
        for (Vehicle a : vehicles) {
            a.move();
            a.discount(30);
        }
    }
}