package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HideBalance {

    public static boolean ButtonIsDisplayed(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement ButtonEye = driver.findElement(By.xpath("//div[@data-at='at-header-balance-icon']"));

        return ButtonEye.isDisplayed();
    }

    public static boolean ButtonEyeState(WebDriver driver, String duringClass){
        //проверка на класс
        //  BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 kNwKE      - not pressed
        //  BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dYPBdJ      - pressed

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Дожидаемся, пока кнопка станет кликабельной
        WebElement ButtonEye = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-at='at-header-balance-icon']")));

        return ButtonEye.getAttribute("class").equals(duringClass);

    }

    public static boolean ClickButtonEye(WebDriver driver) {

        String expRes = "$*********";
        String actRes = "";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ждём, пока загрузочный экран исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-at='at-page-loader-container']")));

        // Дожидаемся, пока кнопка станет кликабельной
        WebElement ButtonEye = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-at='at-header-balance-icon']")));

        ButtonEye.click();

        // Дожидаемся появления баланса
        WebElement Balance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-header-balance-value']")));
        actRes = Balance.getText();

        return expRes.equals(actRes);
    }
}
