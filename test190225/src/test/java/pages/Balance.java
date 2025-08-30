package pages;

import org.example.loginIncomex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

public class Balance {
    private static final Logger logger = LoggerFactory.getLogger(Balance.class);

    //проверка на класс
    public static String ButtonEyeState="";
    public static final String ShowBalanceState = "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 lfNOdk";
    public static final String HideBalanceState = "BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dPMvMO";

    //убираем передачу драйвера в каждую функцию
    private static WebDriver driver;

    public Balance(WebDriver driver) {
        Balance.driver = driver;
    }

    public static void ButtonEyeState() {
        //проверка на класс
        //  BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 kNwKE      - not pressed
        //  BalanceMenustyled__BalanceIcon-sc-xj2ypv-4 dYPBdJ      - pressed

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Дожидаемся, пока кнопка станет кликабельной
        WebElement ButtonEye = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-at='at-header-balance-icon']")));

        ButtonEyeState = ButtonEye.getAttribute("class");

        logger.info("Button Eye State : {}", ButtonEyeState);

    }

    public static boolean CheckButtonEyeState(String state) {
        if (state.equals("hide")) {
            return ButtonEyeState.equals(HideBalanceState);
        } else if (state.equals("show")) {
            return ButtonEyeState.equals(ShowBalanceState);
        }
        return false;
    }

    public static void ClickButtonEye() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ждём, пока загрузочный экран исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-at='at-page-loader-container']")));

        // Дожидаемся, пока кнопка станет кликабельной
        WebElement ButtonEye = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-at='at-header-balance-icon']")));

        ButtonEye.click();

        logger.info("Click Button Eye");
    }

    public static boolean HideBalanceState() {
        String expRes = "$*********";
        String actRes = "";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Дожидаемся появления баланса
        WebElement Balance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-header-balance-value']")));
        actRes = Balance.getText();

        return expRes.equals(actRes);
    }
}
