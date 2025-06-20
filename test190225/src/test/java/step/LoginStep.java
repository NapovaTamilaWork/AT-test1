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

    @Given("^user is opened login page$")
    public void userIsOpenedLoginPage() {
        LoginPage.openPlatform();
    }

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


    @Given("^user is login to the platform$")
    public void userIsLoginToThePlatform() {
        LoginPage.openPlatform();
        LoginPage.enterValidName(Constants.getUsername());
        LoginPage.enterValidPass(Constants.getPassword());
        LoginPage.clickLoginButt();
        LoginPage.isDisplayHomePage();
    }

    @When("^user click more menu button$")
    public void userClickMoreMenuButton() {
        LoginPage.clickMoreMenuButt();
    }

    @And("^user click logout item$")
    public void userClickLogoutItem() {
        LoginPage.clickLogoutItem();
    }

    @And("^user click Yes button$")
    public void userClickYesButton() {
        LoginPage.clickYesOnLogoutWindow();
    }

    @Then("^user see login form$")
    public void userSeeLoginForm() {
        LoginPage.isDisplayLoginPage();
    }
}
