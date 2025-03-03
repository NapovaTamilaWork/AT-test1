package org.example;
import org.junit.*;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.example.loginIncomex.*;

public class loginIncomexTest extends TestCase {
    public static WebDriver driver;
    public static String login = "q29125@dunkos.xyz";
    public static String password = "Password123";


    @BeforeClass
    public static void openPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\AT\\WebDriver\\chrome133\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginInc() {
        assertTrue(loginIncomex.login(driver, login, password));
    }

    @Test
    public void logout() {
        assertTrue(loginIncomex.logout(driver));
    }

    @AfterClass
    public static void ClosePage() {
        driver.quit();
    }
}