package step;

import io.cucumber.java.en.*;
import org.example.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;


public class LoginStep {

    /*@Given("^user is opened login page$")
    public void user_is_opened_login_page() {
        LoginPage.openPlatform();
    }*/

    @When("^user enters valid username and password$")
    public void user_enters_valid_username_and_password() {
        LoginPage.enterValidName(Constants.getUsername());
        LoginPage.enterValidPass(Constants.getPassword());
    }

    @And("^user clicks the login button$")
    public void user_clicks_the_login_button() {
        LoginPage.clickLoginButt();
    }

    @Then("^user should be redirected to the homepage$")
    public void user_should_be_redirected_to_the_homepage() {
        LoginPage.isDisplayHomePage();
    }

    @Given("^user is opened login page$")
    public void userIsOpenedLoginPage() {
        LoginPage.openPlatform();
    }
}
