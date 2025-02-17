package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class hwStrTask {


    public static List<String> stingsTask1(List<String> listString) {
        /*
        Строки
        2.1. Получить лист строк без дубликатов и в верхнем регистре.
        + 2.2. Создать колекцию Person (Иванов, Петров, Сидоров и т.д., с указанием возраста).
        Отсортировать по фамилии и forEach вывести в консоль. Отфильтровать по старше 30, вывести в консоль.
        */

        List<String> UpListString = listString.stream()
                .map(String::toUpperCase) // Преобразуем каждую строку в верхний регистр
                .sorted()
                .collect(Collectors.toList());
        return UpListString;

    }

    public static Map<String, Integer> stingsTask21(Map<String, Integer> Person) {

        //System.out.println("\n Отсортировать по фамилии :  " );
        return Person.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())  // Сортировка по ключу (фамилии)
                //.forEach(e -> System.out.println(e))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


    public static Map<String, Integer> stringsTask22(Map<String, Integer> person) {

        // System.out.println("\n Отфильтровать по старше 30 :  " );
        return person.entrySet().stream()
                .filter(e -> e.getValue() > 30)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}
