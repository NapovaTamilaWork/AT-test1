package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Даны 4 числа типа int. Сравнить их и вывести наименьшее на консоль.
        //Вывести на консоль количество максимальных чисел среди этих четырех.

        /*Scanner console = new Scanner(System.in); // Создание объекта Scanner
        System.out.println("Enter digit 1");
        int number = console.nextInt(); // Считывание ввода пользователя

        System.out.println("Enter digit 2");
        int number2 = console.nextInt(); // Считывание ввода пользователя

        System.out.println("Enter digit 3");
        int number3 = console.nextInt(); // Считывание ввода пользователя

        System.out.println("Enter digit 4");
        int number4 = console.nextInt(); // Считывание ввода пользователя

        int min = number;

        if(number2<min && number2<number3 && number2<number4){
            min = number2;
        }

        if(number3<min && number3<number2 && number3<number4){
            min = number3;
        }

        if(number4<min && number4<number3 && number4<number2){
            min = number4;
        }

        //int min = Math.min(Math.min(number, number2), Math.min(number3, number4));

        System.out.println(min);

        int max = number;

        if(number2>max && number2>number3 && number2>number4){
            max = number2;
        }

        if(number3>max && number3>number2 && number3>number4){
            max = number3;
        }

        if(number4>max && number4>number3 && number4>number2){
            max = number4;
        }

        //int max = Math.max(Math.max(num1, num2), Math.max(num3, num4));

        int maxCount = 0;
        if (number == max) maxCount++;
        if (number2 == max) maxCount++;
        if (number3 == max) maxCount++;
        if (number4 == max) maxCount++;

        System.out.println("Number of maximum numbers: " + maxCount);
*/
        // ------------------------------------------------------------------------------------------------------------------------

        //Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.

        /*int num1 = 1, num2 = 5, num3 = 9, num4 = 4, num5 = 3;

        if(num1<num2 && num1<num3 && num1<num4 && num1<num5)
            System.out.println(num1);

        if(num2<num1 && num2<num3 && num2<num4 && num2<num5)
            System.out.println(num2);

        if(num3<num2 && num3<num1 && num3<num4 && num3<num5)
            System.out.println(num3);

        if(num4<num1 && num4<num3 && num4<num2 && num4<num5)
            System.out.println(num4);

        if(num5<num1 && num5<num3 && num5<num2 && num5<num4)
            System.out.println(num5);

        // --------------------------------------------------

        if(num1>num2 && num1>num3 && num1>num4 && num1>num5)
            System.out.println(num1);

        if(num2>num1 && num2>num3 && num2>num4 && num2>num5)
            System.out.println(num2);

        if(num3>num2 && num3>num1 && num3>num4 && num3>num5)
            System.out.println(num3);

        if(num4>num1 && num4>num3 && num4>num2 && num4>num5)
            System.out.println(num4);

        if(num5<num1 && num5<num3 && num5<num2 && num5<num4)
            System.out.println(num5);
*/
        // ------------------------------------------------------------------------------------------------------------------------

        // Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.

        String s1 = "eee", s2 = "eee";
        if (s1.equals(s2)){
            System.out.println(s1 + " and "+ s2 + " teski");

        }

        // ------------------------------------------------------------------------------------------------------------------------

        //Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.

        /*int month = 12;
        if(month < 13){
            if (month >= 3 && month <= 5)
                System.out.println("vesna");
            else if (month >= 6 && month <= 8)
                System.out.println("leto");
            else if (month >= 9 && month <= 11)
                System.out.println("osien");
            else
                System.out.println("zima");
        } else {
            System.out.println("not a month");
        }
*/
    }
}
