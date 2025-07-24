package pages;

import org.example.Constants;
import org.example.DriverManager;
import org.example.loginIncomex;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage {


    private static final Logger logger = LoggerFactory.getLogger(loginIncomex.class);      //для логгирования

    //убираем передачу драйвера в каждую функцию
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // -------------

    public static void openPlatform(){
        new LoginPage(DriverManager.getDriver());
        driver.get(Constants.getUrl());
        driver.manage().window().maximize();    //окно на весь єкран

        // set the page load timeout to 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    public static void enterValidName(String login){
        WebElement fieldLogin = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-login-input']"));

        fieldLogin.click();
        fieldLogin.sendKeys(login);

        logger.info("enter Valid Name : {}", login);
    }

    public static void enterValidPass(String password){
        WebElement fieldLPassword = driver.findElement(By.xpath("//input[@data-at='at-login-window-block-password-input']"));
        fieldLPassword.sendKeys(password);

        logger.info("enter Valid Password : {}", password);
    }

    public static void clickLoginButt(){
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-at='at-login-block-login-button']"));
        loginButton.click();

        logger.info("click Login Button");
    }

    public static void isDisplayHomePage(){
        WebElement PageLoadScreen = driver.findElement(By.xpath("//div[@data-at='at-page-loader-container']"));

        Assert.assertTrue(PageLoadScreen.isDisplayed());
    }


    public static void clickMoreMenuButt(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Ждём, пока загрузочный экран исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-at='at-page-loader-container']")));
        // Дожидаемся, пока кнопка станет кликабельной
        WebElement moreMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-header-balance-menu-label-icon']")));

        moreMenu.click();

        logger.info("click More Menu Button");
    }

    public static void clickLogoutItem(){
        WebElement logout = driver.findElement(By.xpath("//div[@data-at='at-header-balance-menu-item-label-logout']"));
        logout.click();

        logger.info("click Logout Item Button");
    }

    public static void clickYesOnLogoutWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Ждём, пока загрузочный экран исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-at='at-page-loader-container']")));

        WebElement yes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-at='at-dialogue-option-confirm-yes-button']")));
        yes.click();

        logger.info("click Yes Button On Logout Window");
    }

    public static void isDisplayLoginPage(){
        WebElement PageLogin = driver.findElement(By.xpath("//div[@class='LoginPagestyled__Container-sc-hfjn82-0 brIiuV']"));

        Assert.assertTrue(PageLogin.isDisplayed());
    }

    public static void isDisplayError() {
        WebElement Error;
        Error = driver.findElement(By.xpath("//span[@data-at='at-login-block-error']"));

        Assert.assertTrue(Error.isDisplayed());
    }

    public static void login(String login, String password) {

        openPlatform();

        enterValidName(login);

        enterValidPass(password);

        clickLoginButt();

        WebElement PageLoadScreen = driver.findElement(By.xpath("//div[@data-at='at-page-loader-container']"));

        isDisplayHomePage();
    }

    public static void logout(){

        clickMoreMenuButt();

        clickLogoutItem();

        clickYesOnLogoutWindow();

        isDisplayLoginPage();
    }


}
