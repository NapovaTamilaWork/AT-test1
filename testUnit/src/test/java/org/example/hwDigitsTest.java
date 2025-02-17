package org.example;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class hwDigitsTest {

    private Integer n1;
    private Integer n2;
    private Integer n3;
    private Integer n4;
    private Integer n5;
    private Integer min;
    private Integer max;

    public hwDigitsTest(Integer n1, Integer n2, Integer n3, Integer n4, Integer n5, Integer min, Integer max){
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.min = min;
        this.max = max;
    }

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3, 40, 5, 1, 40},
                {100, 2, 3, 40, 5, 2, 100},
                {1, 2, 3, 4, 5, 1, 5},
                {1, 2, 3, 4, 1, 1, 4},
                {1, 20, 3, 4, 10, 1, 20},
        });
    }

    @Test
    public void minDigit() {
        int act = hwDigits.MinDigit(n1, n2, n3, n4, n5);
        int exp = min;

        assertEquals(exp, act);
    }

    @Test
    public void maxDigit() {
        int act = hwDigits.MaxDigit(n1, n2, n3, n4, n5);
        int exp = max;

        assertEquals(exp, act);
    }
}