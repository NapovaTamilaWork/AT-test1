package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",          // путь к фичам
        glue = {"step"},                             // где искать степы
        plugin = {"pretty", "json:target/runner.json", "junit:target/junit.xml"},     // Отчёты
        monochrome = true,                                   // Чистый вывод в консоли
        tags = "@login"
)

public class RunCucumberTest {
}
