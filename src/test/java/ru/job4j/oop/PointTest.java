package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when13to40then4dot24() {
        double expected = 4.24;
        Point a = new Point(1, 3);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when020to220then3dot60() {
        double expected = 3.60;
        Point a = new Point(0, 2, 0);
        Point b = new Point(2, 2, 3);
        double rsl = a.distance3d(b);
        Assert.assertEquals(expected, rsl, 0.01);
    }
}