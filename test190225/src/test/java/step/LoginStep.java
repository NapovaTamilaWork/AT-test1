package step;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


//  https://youtu.be/V0msKgJEi3o?si=utmNlK9DEmA7_9nv&t=916s


public class LoginStep {

        @Given("^user is opened login page of \"([^\"]*)\"$")
        public void theUserIsOnTheLoginPage() {
            LoginPage.openPlatform();
        }

}
