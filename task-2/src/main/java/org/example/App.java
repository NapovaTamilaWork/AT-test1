package org.example;
import java.io.*;
import java.lang.String;

public class App 
{
    public static void main( String[] args )
    {
        //Используя циклы, символ звездочки и пробелы, вывести в консоль следующие изображения
        int height = 5;
        String star = "";

        for(int i=0; i<height; i++){
            star+= "*";
            System.out.println(star);
        }

        System.out.println();

        star = "";
        int c = 1;
        int h = height-1;
        for(int i=0; i<height; i++){
            star = " ".repeat(h) + "*".repeat(c) + " ".repeat(h);
            System.out.println(star);
            c+=2;
            h--;
        }

        System.out.println();

        star = "";
        c = height*2-1;
        h = 0;
        for(int i=0; i<height; i++){
            star = " ".repeat(h) + "*".repeat(c) + " ".repeat(h);
            System.out.println(star);
            c-=2;
            h++;
        }

        System.out.println();

        star = "";
        h = 0;
        for(int i=0; i<height; i++){
            star = " ".repeat(h) + "*";
            System.out.println(star);
            h++;
        }

        System.out.println();

        star = "";
        h = height-1;
        for(int i=0; i<height; i++){
            star = " ".repeat(h) + "*";
            System.out.println(star);
            h--;
        }

        System.out.println();

        star = "";
        h = height-1;
        for(int i=0; i<height; i++){
            star = "*".repeat(h);
            System.out.println(star);
        }

        System.out.println();

        h = height;
        star = "*".repeat(h);
        System.out.println(star);
        for(int i=0; i<height-1; i++){
            star = "*" + " ".repeat(h-2) + "*";
            System.out.println(star);
        }
        star = "*".repeat(h);
        System.out.println(star);

        System.out.println();

        h = height;
        star = "*".repeat(h);
        System.out.println(star);
        star = "*" + " ".repeat(h-2) + "*";
        System.out.println(star);
        star = "*".repeat(h);
        System.out.println(star);

        for(int i=0; i<height-2; i++){
            star = "**" + " ".repeat(h-4) + "**";
            System.out.println(star);
        }

        star = "*".repeat(h);
        System.out.println(star);
        star = "*" + " ".repeat(h-2) + "*";
        System.out.println(star);
        star = "*".repeat(h);
        System.out.println(star);

    }
}
