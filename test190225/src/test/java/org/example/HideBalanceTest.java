package org.example;

import org.example.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)   //для выполнения кейсов по алфавиту
public class HideBalanceTest {
    public static WebDriver driver;
    public static String login = "q29125@dunkos.xyz";
    public static String password = "Password123";


    @BeforeClass
    public static void openPage() {
        driver = DriverManager.getDriver();     // забрали драйвер из класса
        loginIncomex.login(driver, login, password);
    }


    @Test
    public void test1_buttonIsDisplayed() {
        assertTrue(HideBalance.ButtonIsDisplayed(driver));

    }

    @Test
    public void test2_buttonEyeStateDefault() {
        assertTrue(HideBalance.ButtonEyeState(driver, "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 kNwKE"));
    }

    @Test
    public void test3_clickButtonEye() {
        assertTrue(HideBalance.ClickButtonEye(driver));
    }

    @Test
    public void test4_buttonEyeStateClicked() {
        assertTrue(HideBalance.ButtonEyeState(driver, "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dYPBdJ"));
    }

    @AfterClass
    public static void ClosePage() {
        loginIncomex.logout(driver);
        driver.quit();
    }
}