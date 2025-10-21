package step;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.DriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BrandsSSO {

    private String currentBrand;
    private String accountPageUrl;
    private long ssoButtonTime;
    private long homePageTime;
    private String loginResult;

    private static final String LOG_FILE = "D:\\WORK\\AT\\sso_login_timings.log";

    private void writeLog(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + " | " + text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ===== Получение accountPage из конфига бренда и обрезка до базового URL =====
    public static String getAccountPage(String brandDomain) {
        String configUrl = brandDomain + "/cfg/config.json"; // полный URL к конфигу
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(configUrl).openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Не удалось получить конфиг. Код ответа: " + responseCode);
            }

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder jsonStr = new StringBuilder();
            while (scanner.hasNext()) {
                jsonStr.append(scanner.nextLine());
            }
            scanner.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonStr.toString());

            if (root.has("accountPage")) {
                String fullUrl = root.get("accountPage").asText();
                // Обрезаем до базового URL
                try {
                    URL url = new URL(fullUrl);
                    return url.getProtocol() + "://" + url.getHost();
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Некорректный URL в поле accountPage: " + fullUrl, e);
                }
            } else {
                throw new RuntimeException("Поле accountPage не найдено в конфиге бренда: " + brandDomain);
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при получении конфига бренда: " + brandDomain, e);
        }
    }


    // ===== Steps =====
    @Given("brand {string} config is loaded")
    public void brandConfigIsLoaded(String brandDomain) {
        currentBrand = brandDomain;
        accountPageUrl = getAccountPage(brandDomain);
    }

    @When("user opens account page")
    public void userOpensAccountPage() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(accountPageUrl);
    }

    @Then("measure time until SSO login button is clickable")
    public void measureSSOButtonTime() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        long start = System.currentTimeMillis();
        WebElement ssoButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/button"))
        );
        ssoButtonTime = System.currentTimeMillis() - start;
    }

    @When("user enters username {string} and password {string} on MyAcc")
    public void userEntersCredentials(String username, String password) {
        WebDriver driver = DriverManager.getDriver();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[2]/form/div/div[1]/div/input")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[2]/form/div/div[2]/div/input")).sendKeys(password);
    }

    @When("user clicks SSO login button")
    public void userClicksSSOLoginButton() {
        WebDriver driver = DriverManager.getDriver();
        WebElement ssoButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/button"));
        ssoButton.click();
    }

    /*@When("user clicks first \"Log In\" button on redirected page")
    public void userClicksFirstLogInButton() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement firstLogInButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(normalize-space(.),'Log In')]"))
        );
        firstLogInButton.click();
    }*/
    @When("user clicks first \"Log In\" button on redirected page")
    public void userClicksFirstLogInButton() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // сохраняем текущее окно
        String currentWindow = driver.getWindowHandle();

        WebElement firstLogInButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(normalize-space(.),'Log In')]"))
        );
        firstLogInButton.click();

        // ждём появления новой вкладки
        wait.until(driver1 -> driver1.getWindowHandles().size() > 1);

        // переключаемся на новую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /*@Then("measure time until home page is fully loaded")
    public void measureHomePageTime() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        long start = System.currentTimeMillis();
        try {
            // ждём кликабельности settingsTour
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settingsTour\"]")));

            // ждём исчезновения элемента cfdPlatform
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cfdPlatform\"]/div[3]/div/div")));

            homePageTime = System.currentTimeMillis() - start;
            loginResult = "Авторизация успешна (" + homePageTime + " мс)";
        } catch (Exception e) {
            loginResult = "Ошибка авторизации: " + e.getMessage();
        }
    }*/
    @Then("measure time until home page is fully loaded")
    public void measureHomePageTime() {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // можно увеличить таймаут для медленной загрузки
        long start = System.currentTimeMillis();
        try {
            // ждём кликабельности settingsTour
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"settingsTour\"]")));

            // ждём исчезновения элемента cfdPlatform
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cfdPlatform\"]/div[3]/div/div")));

            homePageTime = System.currentTimeMillis() - start;
            loginResult = "Авторизация успешна (" + homePageTime + " мс)";
        } catch (Exception e) {
            loginResult = "Ошибка авторизации: " + e.getMessage();
        }
    }


    @Then("log timings and result")
    public void logTimingsAndResult() {
        String logLine = "Бренд: " + currentBrand +
                " — SSO кнопка активна через " + ssoButtonTime + " мс" +
                " | " + loginResult;
        writeLog(logLine);
    }
}
