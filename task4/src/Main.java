import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        Числа
        + 1.1. Вывести четные числа.
        + 1.2. Вывести количество нечетных чисел.
        + 1.3. Вывести в консоль первые 5 из 10 чисел.
        + 1.4. Отсортировать в порядке возрастания.
        + 1.5. Отсортировать в обратном порядке.
        + 1.6. Убираем дубликаты чисел. Представить результаты в виде коллекции и вывести результаты в консоль.
        + 1.7. Числа преобразуем в String и ищем среди них содержащие "1"
        + 1.8. Найти первое число больше 30.
        + 1.9. Найти max & min.
        1.10. Найти сумму чисел и среднее.
    */


        /*
        int listSize = 10; // количество чисел в списке
        int min = 1; // минимальное значение (включительно)
        int max = 100; // максимальное значение (включительно)

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < listSize; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min; // Генерация случайного числа
            numbers.add(randomNumber);
        }


        System.out.println("Список чисел :  " + numbers);


        System.out.println("\n четные числа :  ");
        numbers.stream().filter(e -> e%2==0).forEach(e -> System.out.println(e));

        System.out.println("\n количество нечетных чисел :  " + numbers.stream().filter(e -> e%2!=0).count());

        System.out.println("\n первые 5 из 10 чисел :  ");
        numbers.stream()
                .limit(5) // Ограничиваем поток первыми 5 элементами
                .forEach(e -> System.out.println(e));

        System.out.println("\n Отсортировать в порядке возрастания :  " );
        numbers.stream().sorted().forEach(e -> System.out.println(e));  // Сортировка по умолчанию (в порядке возрастания)

        System.out.println("\n Отсортировать в обратном порядке :  " );
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println(e));  // Используем обратный компаратор

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct() // Убираем дубликаты
                .collect(Collectors.toList()); // Преобразуем обратно в список
        System.out.println("\n Убираем дубликаты чисел. Представить результаты в виде коллекции и вывести результаты в консоль :  " + uniqueNumbers);

        List<String> filteredNumbers = numbers.stream()
                .map(String::valueOf) // Преобразуем числа в строки
                .filter(s -> s.contains("1")) // Фильтруем строки, содержащие "1"
                .collect(Collectors.toList()); // Преобразуем обратно в список
        System.out.println("\n Числа преобразуем в String и ищем среди них содержащие 1 :  " + filteredNumbers);

        System.out.println("\n Найти первое число больше 30 :  " +
        numbers.stream()
                .filter(num -> num > 30) // Фильтруем числа больше 30
                .findFirst() // Находим первое подходящее
        );

        //Найти max & min
        System.out.println("\n MAX :  " +
        numbers.stream()
                .max(Comparator.naturalOrder())
        );
        System.out.println("\n MIN :  " +
        numbers.stream()
                .min(Comparator.naturalOrder())
        );

        System.out.println("\n Найти сумму чисел и среднее :  ");

        System.out.println(
            numbers.stream()
                .mapToInt(Integer::intValue) // Преобразуем в IntStream
                .sum()
        );

        System.out.println(
            numbers.stream()
                .mapToInt(Integer::intValue) // Преобразуем в IntStream
                .average()
        );
        */

        /*
        Строки
        2.1. Получить лист строк без дубликатов и в верхнем регистре.
        + 2.2. Создать колекцию Person (Иванов, Петров, Сидоров и т.д., с указанием возраста).
        Отсортировать по фамилии и forEach вывести в консоль. Отфильтровать по старше 30, вывести в консоль.
        */

        List<String> listString = new ArrayList<>();
        listString.add("aaa");
        listString.add("ccC");
        listString.add("Ddd");
        listString.add("bBb");


        List<String> UpListString = listString.stream()
                .map(String::toUpperCase) // Преобразуем каждую строку в верхний регистр
                .sorted()
                .collect(Collectors.toList());
        System.out.println(UpListString);

        /*
        Map<String, Integer> Person = new HashMap<>();
        Person.put("Иванов", 17);
        Person.put("Петров", 16);
        Person.put("Сидоров", 18);
        Person.put("Аннич", 45);

        System.out.println("\n Отсортировать по фамилии :  " );
        Person.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())  // Сортировка по ключу (фамилии)
                .forEach(e -> System.out.println(e));

        System.out.println("\n Отфильтровать по старше 30 :  " );
        Person.entrySet().stream().filter(e -> e.getValue() > 30).forEach(e -> System.out.println(e));
        */

    }
}