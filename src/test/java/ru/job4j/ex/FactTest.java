package ru.job4j.ex;

import org.junit.Test;
import ru.job4j.ru.job4j.ex.Fact;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Fact.calc(-1);
    }

    @Test
    public void when4Then24Finish() {
        int rsl = Fact.calc(4);
        assertThat(rsl, is(24));
    }
}