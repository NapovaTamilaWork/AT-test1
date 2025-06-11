package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loginIncomex {

    private static final Logger logger = LoggerFactory.getLogger(loginIncomex.class);      //для логгирования

    public static void enterValidName(WebDriver driver, String login){
        WebElement fieldLogin = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-login-input']"));

        fieldLogin.click();
        fieldLogin.sendKeys(login);

        logger.info("enter Valid Name : {}", login);
    }

    public static void enterValidPass(WebDriver driver, String password){
        WebElement fieldLPassword = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-password-input']"));
        fieldLPassword.sendKeys(password);

        logger.info("enter Valid Password : {}", password);
    }

    public static void clickLoginButt(WebDriver driver){
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-at='at-login-block-login-button']"));
        loginButton.click();

        logger.info("click Login Button");
    }

    public static void clickMoreMenuButt(WebDriver driver, WebDriverWait wait){
        // Дожидаемся, пока кнопка станет кликабельной
        WebElement moreMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-header-balance-menu-label-icon']")));

        moreMenu.click();

        logger.info("click More Menu Button");
    }

    public static void clickLogoutItem(WebDriver driver){
        WebElement logout = driver.findElement(By.xpath("//div[@data-at='at-header-balance-menu-item-label-logout']"));
        logout.click();

        logger.info("click Logout Item Button");
    }

    public static void clickYesOnLogoutWindow(WebDriver driver, WebDriverWait wait){
        WebElement yes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-dialogue-option-confirm-yes-button']")));
        yes.click();

        logger.info("click Yes Button On Logout Window");
    }



    public static boolean login(WebDriver driver, String login, String password) {
        driver.get(Constants.getUrl());
        driver.manage().window().maximize();    //окно на весь єкран

        // set the page load timeout to 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));


        enterValidName(driver, login);

        enterValidPass(driver, password);

        clickLoginButt(driver);

        WebElement PageLoadScreen = driver.findElement(By.xpath("//div[@data-at='at-page-loader-container']"));

        return PageLoadScreen.isDisplayed();
    }

    public static boolean logout(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Ждём, пока загрузочный экран исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-at='at-page-loader-container']")));

        clickMoreMenuButt(driver, wait);

        clickLogoutItem(driver);

        clickYesOnLogoutWindow(driver, wait);

        WebElement PageLogin = driver.findElement(By.xpath("//div[@class='LoginPagestyled__Container-sc-hfjn82-0 brIiuV']"));

        return PageLogin.isDisplayed();
    }
}
