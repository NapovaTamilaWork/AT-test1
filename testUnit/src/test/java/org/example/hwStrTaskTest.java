package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import org.junit.*;

import static org.example.hwStrTask.stingsTask21;
import static org.junit.Assert.*;


public class hwStrTaskTest {

    @Test
    public void stingsTask1() {
        List<String> listStr = new ArrayList<>();
        listStr.add("aaa");
        listStr.add("ccC");
        listStr.add("Ddd");
        listStr.add("bBb");

        List<String> exp = new ArrayList<>();
        exp.add("AAA");
        exp.add("BBB");
        exp.add("CCC");
        exp.add("DDD");

        assertEquals(exp, hwStrTask.stingsTask1(listStr));
    }

    @Test
    public void stingsTask21() {
        Map<String, Integer> Pers = new HashMap<>();
        Pers.put("Иванов", 17);
        Pers.put("Петров", 16);
        Pers.put("Сидоров", 18);
        Pers.put("Аннич", 45);

        Map<String, Integer> exp = new HashMap<>();
        exp.put("Аннич", 45);
        exp.put("Иванов", 17);
        exp.put("Петров", 16);
        exp.put("Сидоров", 18);

        assertEquals( exp , hwStrTask.stingsTask21(Pers));

    }

    @Test
    public void stingsTask22() {
        Map<String, Integer> Pers = new HashMap<>();
        Pers.put("Иванов", 17);
        Pers.put("Петров", 16);
        Pers.put("Сидоров", 18);
        Pers.put("Аннич", 45);

        Map<String, Integer> exp = new HashMap<>();
        exp.put("Аннич", 45);

        assertEquals( exp , hwStrTask.stringsTask22(Pers));

    }
}