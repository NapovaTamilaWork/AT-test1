package org.example;
import org.junit.*;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.runners.MethodSorters;   //для выполнения кейсов по алфавиту
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.example.Constants;
import pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)   //для выполнения кейсов по алфавиту
public class loginIncomexTest {

    public static WebDriver driver;
    public static String login = Constants.getUsername();
    public static String password = Constants.getPassword();

    @BeforeClass
    public static void openPage() {
        driver = DriverManager.getDriver();          // забрали драйвер из класса
        new LoginPage(driver);
    }

    @Test
    public void test1_login() {
        assertTrue(loginIncomex.login(login, password));
    }

    @Test
    public void test2_logout() {
        assertTrue(loginIncomex.logout());
    }

    @AfterClass
    public static void ClosePage() {
        driver.quit();
    }

}