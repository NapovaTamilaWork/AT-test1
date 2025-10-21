package step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.DriverManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        // Получаем и сохраняем драйвер
        driver = DriverManager.getDriver();
        System.out.println("✅ Браузер открыт");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
            System.out.println("🧹 Браузер закрыт");
        }
    }
}
