package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    // Приватный конструктор — чтобы нельзя было создать экземпляр
    private DriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            // Здесь выбирается браузер. Можно сделать через переменную или config-файл
            String browser = System.getProperty("browser", "chrome");

            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    System.setProperty("webdriver.chrome.driver", "D:\\WORK\\AT\\WebDriver\\chrome138\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
