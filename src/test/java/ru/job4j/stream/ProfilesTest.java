package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenAddress() {
        Address address = new Address("Neryungri", "Timptonskaya", 7, 78);
        Address address1 = new Address("Moscow", "Lenina", 2, 23);
        Profile profile = new Profile(address);
        Profile profile1 = new Profile(address1);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        List<Profile> profileList = new ArrayList<>();
        profileList.add(profile);
        profileList.add(profile1);
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profileList), is(addresses));

    }
}