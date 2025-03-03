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
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\AT\\WebDriver\\chrome133\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        System.out.println(login(driver, "q29125@dunkos.xyz", "Password123"));

        //System.out.println(ButtonIsDisplayed(driver));

        //System.out.println(ButtonEyeState(driver, "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 kNwKE"));

        //System.out.println(ClickButtonEye(driver));

        //System.out.println(ButtonEyeState(driver, "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dYPBdJ"));

        logout(driver);

    }
}
