package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class HideBalanceTest {
    public static WebDriver driver;
    public static String login = "q29125@dunkos.xyz";
    public static String password = "Password123";


    @BeforeClass
    public static void openPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\AT\\WebDriver\\chrome133\\chromedriver.exe");
        driver = new ChromeDriver();
        loginIncomex.login(driver, login, password);
    }


    @Test
    public void buttonIsDisplayed() {
        assertTrue(HideBalance.ButtonIsDisplayed(driver));

    }

    /*@Test
    public void buttonEyeState() {
    }

    @Test
    public void clickButtonEye() {
    }*/

    @AfterClass
    public static void ClosePage() {
        loginIncomex.logout(driver);
        driver.quit();
    }
}