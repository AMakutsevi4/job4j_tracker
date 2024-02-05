package ru.job4j.enumeration;

public class Order {

    private int number;
    private String car;
    private Status status;

    public Order(int number, String car, Status status) {
        this.number = number;
        this.car = car;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

    /*
    ACCEPTED("Принят"),
    IN_WORK("В работе"),
    WAITING("Ожидание"),
    FINISHED("Работы завершены");

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
    */

