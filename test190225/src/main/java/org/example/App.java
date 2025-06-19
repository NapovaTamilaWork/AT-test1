package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.example.loginIncomex.*;
import static org.example.HideBalance.*;


public class App 
{
    public static void main( String[] args ) {
        WebDriver driver = DriverManager.getDriver();            // забрали драйвер из класса



        //System.out.println(login("q29125@dunkos.xyz", "Password123"));

        //System.out.println(ButtonIsDisplayed());

        //System.out.println(ButtonEyeState("BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 kNwKE"));

        //System.out.println(ClickButtonEye());

        //System.out.println(ButtonEyeState("BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dYPBdJ"));

        //logout();

    }
}
