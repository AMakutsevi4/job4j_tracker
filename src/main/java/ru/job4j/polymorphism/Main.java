package ru.job4j.polymorphism;

public class Main {
    public static void main(String[] args) {
        Vehicle townCar = new TownCar();
        townCar.accelerate();
        townCar.brake();
        townCar.changeGear();
        townCar.steer();
        townCar.refill();

        System.out.println("\n");
        SportCar sportCar = new SportCar();
        Vehicle vehicle = sportCar;
        Fuel fuel = sportCar;
        vehicle.steer();
        vehicle.changeGear();
        vehicle.brake();
        vehicle.accelerate();
        fuel.refill();

    }
}
