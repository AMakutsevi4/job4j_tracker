package ru.job4j.queue;

import java.util.Objects;

public class Customer {
    private final String name;
    private final int amount;

    public Customer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Customer) obj;
        return Objects.equals(this.name, that.name)
                && this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return "Customer["
                + "name=" + name + ", "
                + "amount=" + amount + ']';
    }

}