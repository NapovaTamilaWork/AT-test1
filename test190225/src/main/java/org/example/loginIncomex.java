package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class loginIncomex {
    public static boolean login(WebDriver driver, String login, String password) {
        driver.get("https://dev-trading.incomex.org/login.html");
        driver.manage().window().maximize();    //окно на весь єкран

        // set the page load timeout to 15 seconds
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        WebElement fieldLogin = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-login-input']"));

        fieldLogin.click();
        fieldLogin.sendKeys(login);

        WebElement fieldLPassword = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-password-input']"));
        fieldLPassword.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-at='at-login-block-login-button']"));
        loginButton.click();

        WebElement PageLoadScreen = driver.findElement(By.xpath("//div[@data-at='at-page-loader-container']"));

        return PageLoadScreen.isDisplayed();
    }

    public static void logout(){

    }
}
