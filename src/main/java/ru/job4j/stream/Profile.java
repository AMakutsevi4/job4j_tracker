package ru.job4j.stream;

import java.util.List;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profiles{"
                + "address=" + address
                + '}';
    }
}
