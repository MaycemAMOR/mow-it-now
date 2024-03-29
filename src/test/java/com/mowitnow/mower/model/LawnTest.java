package com.mowitnow.mower.model;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LawnTest {
    @Test
    public void check_overload_equals() {
        Lawn l1 = new Lawn(new Coordinates(1, 2));
        Lawn l2 = new Lawn(new Coordinates(1, 2));
        assertThat(l1.equals(l2)).isTrue();
        l2 = new Lawn(new Coordinates(1, 3));
        assertThat(l1.equals(l2)).isFalse();
    }
}
