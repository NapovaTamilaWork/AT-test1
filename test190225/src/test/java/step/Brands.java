package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Brands {
    String currentBrand;
    long buttonTime;
    long loginTime;
    long start;
    String loginResult;

    // путь к лог-файлу
    private static final String LOG_FILE = "D:\\WORK\\AT\\login_timings.log";
    // утилита для записи в файл
    private void writeLog(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + " | " + text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Given("user opens {string} platform")
    public void userOpensPlatform(String brand) {
        currentBrand = brand;
        DriverManager.getDriver().get(brand);
        start = System.currentTimeMillis();
        buttonTime = 0;
        loginTime = 0;
        loginResult = "";
    }

    @When("user waits until login button is active")
    public void userWaitsUntilLoginButtonIsActive() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btLogin\"]")));
        buttonTime = System.currentTimeMillis() - start;
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        DriverManager.getDriver().findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(username);
        DriverManager.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    }

    @When("user clicks login button and waits for home page")
    public void userClicksLoginButtonAndWaitsForHomePage() {
        WebDriver driver = DriverManager.getDriver();
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btLogin\"]"));
        long startLogin = System.currentTimeMillis();
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // ждём кликабельности settingsTour
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settingsTour\"]")));

            // ждём исчезновения элемента cfdPlatform
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cfdPlatform\"]/div[3]/div/div")));

            loginTime = System.currentTimeMillis() - startLogin;
            loginResult = "Авторизация успешна (" + loginTime + " мс)";
        } catch (Exception e) {
            // если появляется сообщение об ошибке
            WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"appLogin\"]/div/div[2]/div[4]/div"));
            loginResult = "Ошибка авторизации: " + errorMsg.getText();
        }
    }

    @Then("log brand and timings")
    public void logBrandAndTimings() {
        String logLine = "Бренд: " + currentBrand +
                " — кнопка активна через " + buttonTime + " мс" +
                " | " + loginResult;

        // запись в файл
        writeLog(logLine);
    }
}
