package ru.job4j.ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void gofar() {

    }

    @Override
    public void sayNumPassengers(int number) {

    }

    @Override
    public int fuelprice(int fuel) {
        return fuel * fuelprice(55);
    }
}