package ru.job4j.ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void gofar() {
        System.out.println("Bus travels to destination");
    }

    @Override
    public void sayNumPassengers(int number) {
        System.out.println("On the bus is: " + number + "passengers");
    }

    @Override
    public int fuelprice(int fuel) {
        return fuel * fuelprice(55);
    }
}