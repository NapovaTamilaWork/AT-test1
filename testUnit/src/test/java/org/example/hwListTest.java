package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class hwListTest {

    public List<Integer> numbers = new ArrayList<>();
    public List<Integer> exp = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(1);
        numbers.add(3);
        numbers.add(1);

        exp.add(1);
        exp.add(3);
    }

    @Test
    public void digitsTask() {
        assertEquals(exp, hwList.DigitsTask(numbers));
    }
}