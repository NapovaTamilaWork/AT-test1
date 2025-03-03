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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)   //для выполнения кейсов по алфавиту
public class loginIncomexTest {
    public static WebDriver driver;
    public static String login = "q29125@dunkos.xyz";
    public static String password = "Password123";

    @BeforeClass
    public static void openPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\AT\\WebDriver\\chrome133\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1_login() {
        assertTrue(loginIncomex.login(driver, login, password));
    }

    @Test
    public void test2_logout() {
        assertTrue(loginIncomex.logout(driver));
    }

    @AfterClass
    public static void ClosePage() {
        driver.quit();
    }

}