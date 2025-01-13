import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void RegStr(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        /*
        Выведите в консоль с использованием регулярки
        Дана строка 'ahb acb aeb aeeb adcb axeb'. по шаблону: буква 'a', любой символ, буква 'b'.
        */
        //  a.b
        String str1 = "ahb acb aeb aeeb adcb axeb";
        RegStr(str1, "a.b");

        //Дана строка 'aa aba abba abbba abca abea'. по шаблону: буква 'a', буква 'b' любое количество раз, буква 'a'.
        //  ab+a
        str1 = "aa aba abba abbba abca abea";
        RegStr(str1, "ab+a");

        //Дана строка '*+ *q+ *qq+ *qqq+ *qqq qqq+'. Напишите регулярку, которая найдет строки *q+, *qq+, *qqq+, не захватив остальные.
        //  [*]q+[+]
        str1 = "*+ *q+ *qq+ *qqq+ *qqq qqq+";
        RegStr(str1, "[*]q+[+]");

        //Дана строка 'aa aba abba abbba abbbba abbbbba'. Напишите регулярку, которая найдет строки вида aba, в которых 'b' встречается более 4-х раз (включительно).
        //  ab{4,}a
        str1 = "aa aba abba abbba abbbba abbbbba";
        RegStr(str1, "ab{4,}a");

        //Дана строка 'ave a#b a2b a$b a4b a5b a-b acb'. Напишите регулярку, которая найдет строки следующего вида: по краям стоят буквы 'a' и 'b', а между ними - не буква и не цифра.
        //  a\Wb
        str1 = "ave a#b a2b a$b a4b a5b a-b acb";
        RegStr(str1, "a\\Wb");

        // строка 'aba aea aca aza axa a-a a#a'. Напишите регулярку, которая найдет строки следующего вида: по краям стоят буквы 'a', а между ними - не 'e' и не 'x'.
        //  a[^ex\s]a
        str1 = "aba aea aca aza axa a-a a#a";
        RegStr(str1, "a[^ex\\s]a");


        //Проверить, что переданная строка является емэйлом.
        // Примеры емэйлов для тестирования mymail@mail.ru my.mail@google.com my-mail@i.ua my_mail@ukr.net mail@mail.com mail@mail.by mail@yandex.ru.
        //  [a-z,A-Z,0-9]*[-_.]*[a-z,A-Z,0-9]*@\w{1,6}[.]\w{2,3}
        str1 = "mymail@mail.ru my.mail@google.com my-mail@i.ua my_mail@ukr.net mail@mail.com mail@mail.by mail@yandex.ru";
        RegStr(str1, "[a-z,A-Z,0-9]*[-_.]*[a-z,A-Z,0-9]*@\\w{1,6}[.]\\w{2,3}");

        //Определите, что переданная строка является доменом. Примеры доменов: http://site.ua, https://site.com, http://my-site.com, https://my.site.com, http://my_site.com.
        //  https{0,1}:[/]{2}[a-z]+[-_.]*[a-z]*[.][a-z]+
        str1 = "aa http://site.ua, https://site.com, http://my-site.com, abbba abca https://my.site.com, http://my_site.com aba abba  abea";
        RegStr(str1, "https{0,1}:[/]{2}[a-z]+[-_.]*[a-z]*[.][a-z]+");

        //Определите, что год находится в интервале от 1900 до 2100 с помощью одного только регулярного выражения.
        //  19[0-9]{2}|20[0-9]{2}|2100
        str1 = "2200 2102 1958 1900 2100";
        RegStr(str1, "19[0-9]{2}|20[0-9]{2}|2100");

        //Определите, что переданная строка является корректным временем вида
        // '12:59', '23:41', '00:12', '00:00', '09:15'. Время '24.00', '25.00', '12.60', '12.93', '41.93' является некорректным.
        //  (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]
        str1 = "'12:59', '23:41', '00:12', '00:00', '09:15'. Время '24.00', '25.00', '12.60', '12.93', '41.93' является некорректным";
        RegStr(str1, "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]");

    }
}