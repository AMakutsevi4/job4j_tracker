package ru.job4j.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    public void when00to20Then2() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        int expected = 2;
        double out = first.distance(second);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when12to34Then2() {
        Point first = new Point(1, 2);
        Point second = new Point(3, 4);
        double expected = 2.8284271247461903;
        double out = first.distance(second);
        Assertions.assertEquals(expected, out, 0.01);
    }
}