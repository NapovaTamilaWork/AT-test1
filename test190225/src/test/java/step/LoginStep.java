package step;

import io.cucumber.java.en.*;
import org.example.Constants;
import org.example.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


import java.time.Duration;


public class LoginStep {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("^user is opened login page$")
    public void userIsOpenedLoginPage() {
        loginPage.openPlatform();
    }

    @When("^user enters valid username and password$")
    public void user_enters_valid_username_and_password() {
        loginPage.enterValidName(Constants.getUsername());
        loginPage.enterValidPass(Constants.getPassword());
    }

    @When("^user enters invalid username and password$")
    public void userEntersInvalidUsernameAndPassword() {
        loginPage.enterValidName(Constants.getBadUsername());
        loginPage.enterValidPass(Constants.getBadPassword());
    }

    @And("^user clicks the login button$")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButt();
    }

    @Then("^user should be redirected to the homepage$")
    public void user_should_be_redirected_to_the_homepage() {
        loginPage.isDisplayHomePage();
    }


    @Given("^user is login to the platform$")
    public void userIsLoginToThePlatform() {
        /*LoginPage.openPlatform();
        LoginPage.enterValidName(Constants.getUsername());
        LoginPage.enterValidPass(Constants.getPassword());
        LoginPage.clickLoginButt();
        LoginPage.isDisplayHomePage();*/

        loginPage.login(Constants.getUsername(), Constants.getPassword());
    }

    @When("^user click more menu button$")
    public void userClickMoreMenuButton() {
        loginPage.clickMoreMenuButt();
    }

    @And("^user click logout item$")
    public void userClickLogoutItem() {
        loginPage.clickLogoutItem();
    }

    @And("^user click Yes button$")
    public void userClickYesButton() {
        loginPage.clickYesOnLogoutWindow();
    }

    @Then("^user see login form$")
    public void userSeeLoginForm() {
        loginPage.isDisplayLoginPage();
    }

    @Then("^user see an error$")
    public void userSeeAnError() {
        loginPage.isDisplayError();
    }

}
