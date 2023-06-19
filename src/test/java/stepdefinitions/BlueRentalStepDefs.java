package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BRHomePage;
import pages.BRLoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class BlueRentalStepDefs {
    BRHomePage brHomePage = new BRHomePage();
    BRLoginPage brLoginPage = new BRLoginPage();

    @Given("user clicks on home page login button")
    public void user_clicks_on_home_page_login_button() {
        brHomePage.homeLoginLink.click();
    }
    @Given("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        brLoginPage.userEmail.sendKeys(string);
        brLoginPage.userPass.sendKeys(string2);
    }
    @Given("user clicks on the login page login button")
    public void user_clicks_on_the_login_page_login_button() {
        brLoginPage.loginButton.click();
    }
    @Then("verify the default page is visible")
    public void verify_the_default_page_is_visible() {
        ReusableMethods.verifyElementDisplayed(brHomePage.userID);
    }
    @Then("user logs out the application")
    public void user_logs_out_the_application() {
        brHomePage.userID.click();
        brHomePage.logOut.click();
        brHomePage.OK.click();
    }

}
