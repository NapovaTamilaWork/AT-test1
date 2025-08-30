package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.Balance;

public class BalanceStep {
    @When("^user is pay attention to the eye button$")
    public void userIsPayAttentionToTheEyeButton() {
        Balance.ButtonEyeState();
    }


    @Then("^user see balance state \"(show|hide)\"$")
    public void userSeeShowBalanceState(String expectedState) {
        Assert.assertTrue(Balance.CheckButtonEyeState(expectedState));
    }

    @And("^user click on eye button$")
    public void userClickOnEyeButton() {
        Balance.ClickButtonEye();
    }

    @Then("^user see hide balance$")
    public void userSeeHideBalance() {
        Balance.HideBalanceState();
    }
}
