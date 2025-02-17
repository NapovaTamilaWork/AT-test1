package org.example;

public class hwString {

    public static String CompareNames(String s1, String s2) {
        // Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.

        if (s1.equals(s2)){
            return "teski";
        }
        return "no";
    }

    public static String Month(int month) {
        //Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.

        if(month < 13){
            if (month >= 3 && month <= 5)
                return "vesna";
            else if (month >= 6 && month <= 8)
                return "leto";
            else if (month >= 9 && month <= 11)
                return "osien";
            else
                return "zima";
        } else {
            return "not a month";
        }
    }

}
