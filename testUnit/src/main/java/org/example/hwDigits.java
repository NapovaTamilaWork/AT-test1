package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class hwDigits {

    public static int MinDigit(int num1, int num2, int num3, int num4, int num5) {
        //Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.

        if (num1 < num2 && num1 < num3 && num1 < num4 && num1 < num5)
            return num1;

        if (num2 < num1 && num2 < num3 && num2 < num4 && num2 < num5)
            return num2;

        if (num3 < num2 && num3 < num1 && num3 < num4 && num3 < num5)
            return num3;

        if (num4 < num1 && num4 < num3 && num4 < num2 && num4 < num5)
            return num4;

        if (num5 < num1 && num5 < num3 && num5 < num2 && num5 < num4)
            return num5;

        return -1;
    }

    public static int MaxDigit(int num1, int num2, int num3, int num4, int num5) {
        if (num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5) {
            return num1;
        } else {
            if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
                return num2;
            } else {
                if (num3 > num2 && num3 > num1 && num3 > num4 && num3 > num5) {
                    return num3;
                } else {
                    if (num4 > num1 && num4 > num3 && num4 > num2 && num4 > num5) {
                        return num4;
                    } else {
                        if (num5 < num1 && num5 < num3 && num5 < num2 && num5 < num4) {
                            return num5;
                        }
                    }
                }
            }

            return -1;
        }


    }

}