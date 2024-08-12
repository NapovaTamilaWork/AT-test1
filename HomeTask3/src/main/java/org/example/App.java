package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        //Создать список строк, например перечень фруктов. Добавить в начало, в середину и в конец какие-нибудь овощи.
        //Вывести список до и после.

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        System.out.println(fruits);

        fruits.add(0, "Carrot"); // В начало списка
        fruits.add(fruits.size() / 2, "Lettuce"); // В середину списка
        fruits.add("Broccoli"); // В конец списка

        System.out.println(fruits);

        //------------------------------------------------------------------------------------------

        //Создать список строк, Удалить начало, любой из середины и в конечный элемент. Вывести список до и после.

        /*
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        System.out.println(fruits);

        // Удаление элемента из начала списка
        fruits.remove(0);
        // Удаление элемента из середины списка
        fruits.remove(fruits.size() / 2);
        // Удаление элемента из конца списка
        fruits.remove(fruits.size() - 1);

        System.out.println(fruits);
         */

        //------------------------------------------------------------------------------------------

        //У вас список цветов. Вывести индекс желтого.

        /*
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println(colors.indexOf("Yellow"));
         */

        //------------------------------------------------------------------------------------------

        //Методы списков:
        //4.1. Наполнить колекцию случайными числами. Вывести её.
        //4.2. Вывести максимальное и минимальное число.
        //4.3. Отсортировать и вывести в консоль отсортированый список.
        //4.4. Применить обратную сортировку - вывести список.
        //4.5. Перемешать список и вывести его.

        /*
        // 4.1. Наполнить коллекцию случайными числами и вывести её.
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            numbers.add(rand.nextInt(100)); // Добавление случайного числа от 0 до 99
        }

        System.out.println("Список случайных чисел: " + numbers);

        // 4.2. Вывести максимальное и минимальное число.
        int maxNumber = Collections.max(numbers);
        int minNumber = Collections.min(numbers);
        System.out.println("Максимальное число: " + maxNumber);
        System.out.println("Минимальное число: " + minNumber);

        // 4.3. Отсортировать и вывести в консоль отсортированный список.
        Collections.sort(numbers);
        System.out.println("Отсортированный список: " + numbers);

        // 4.4. Применить обратную сортировку и вывести список.
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Список в обратном порядке: " + numbers);

        // 4.5. Перемешать список и вывести его.
        Collections.shuffle(numbers);
        System.out.println("Перемешанный список: " + numbers);
         */

        //------------------------------------------------------------------------------------------

        // У вас колекция овощей. Поменять местами в списке елементы "Помидор" и "Картошка".

        /*
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Tomato");
        fruits.add("Cherry");
        fruits.add("Patata");

        System.out.println(fruits);

        int Tomatoind = fruits.indexOf("Tomato");
        int Patataind = fruits.indexOf("Patata");

        fruits.remove(Tomatoind);
        fruits.add(Tomatoind, "Patata");

        fruits.remove(Patataind);
        fruits.add(Patataind, "Tomato");

        System.out.println(fruits);
         */

        //------------------------------------------------------------------------------------------

        //Сравнение списков:
        //6.1. Выяснить есть ли общие элементы у двух списков.
        //6.2. Вывести отличия двух списков.

        /*
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5);

        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 4, 5, 6, 7, 8);

        // 6.1. Выяснить, есть ли общие элементы у двух списков.
        List<Integer> commonElements = new ArrayList<>(list1);
        commonElements.retainAll(list2);

        if (!commonElements.isEmpty()) {
            System.out.println("Общие элементы: " + commonElements);
        } else {
            System.out.println("Общих элементов нет.");
        }

        // 6.2. Вывести отличия двух списков.
        List<Integer> uniqueInList1 = new ArrayList<>(list1);
        uniqueInList1.removeAll(list2);

        List<Integer> uniqueInList2 = new ArrayList<>(list2);
        uniqueInList2.removeAll(list1);

        List<Integer> differences = new ArrayList<>(uniqueInList1);
        differences.addAll(uniqueInList2);

        System.out.println("Отличия двух списков: " + differences);
         */

        //------------------------------------------------------------------------------------------

        // Убрать из листа повторяющиеся элементы.

        /*List<String> myList = new LinkedList<>();
        Collections.addAll(myList, "a", "b", "c", "b");
        Set<String> mySet = new HashSet<>(myList);

        System.out.println(mySet);
         */
    }
}
