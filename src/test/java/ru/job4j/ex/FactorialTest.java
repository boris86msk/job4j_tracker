package ru.job4j.ex;

import org.junit.Test;

public class FactorialTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
         Factorial.calc(-1);
    }
}