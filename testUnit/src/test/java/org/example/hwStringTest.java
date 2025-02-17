package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class hwStringTest {

    @Test
    public void compareNamesTrue() {
        assertEquals("teski", hwString.CompareNames("Ivan", "Ivan"));
    }

    @Test
    public void compareNamesFalse() {
        assertEquals("no", hwString.CompareNames("Ivan", "Igor"));
    }

    @Test
    public void month() {
        assertEquals("vesna", hwString.Month(3));
    }

    @Test
    public void NotMonth() {
        assertEquals("not a month", hwString.Month(32));
    }
}