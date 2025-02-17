package org.example;
import java.util.*;

import static org.example.hwDigits.*;
import static org.example.hwString.*;
import static org.example.hwStrTask.*;
import static org.example.hwList.*;


public class App 
{



    public static void main(String[] args) {

        //System.out.println(MinDigit(1, 2, 3, 4, 0));

       // System.out.println(MaxDigit(1, 2, 3, 4, 5));

        //System.out.println(CompareNames("qwr", "qwr"));

        //System.out.println(Month(10));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(1);
        numbers.add(3);
        numbers.add(1);

        //System.out.println(DigitsTask(numbers));



        List<String> listStr = new ArrayList<>();
        listStr.add("aaa");
        listStr.add("ccC");
        listStr.add("Ddd");
        listStr.add("bBb");

        //System.out.println(stingsTask1(listStr));



        Map<String, Integer> Pers = new HashMap<>();
        Pers.put("Иванов", 17);
        Pers.put("Петров", 16);
        Pers.put("Сидоров", 18);
        Pers.put("Аннич", 45);

        //stingsTask21(Pers);

        //stringsTask22(Pers);



    }
}
