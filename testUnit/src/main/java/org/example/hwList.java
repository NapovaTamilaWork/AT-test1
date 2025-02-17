package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class hwList {

    public static List<Integer> DigitsTask(List<Integer> numbers) {

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct() // Убираем дубликаты
                .collect(Collectors.toList()); // Преобразуем обратно в список

        return uniqueNumbers;
    }

}
