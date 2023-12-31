package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class GoogleStepDefs {

    GooglePage googlePage = new GooglePage();
    @Given("user is on the google home page")
    public void user_is_on_the_google_home_page() {

        Driver.getDriver().get(ConfigReader.getProperty("google_url"));

        try {
            googlePage.popUpAccept.click();
        }catch (Exception e){

        }
    }
    @Given("user search for iPhone")
    public void user_search_for_i_phone() {

        googlePage.searchbox.sendKeys("iPhone", Keys.ENTER);
    }
    @Then("verify the page title contains iPhone")
    public void verify_the_page_title_contains_i_phone() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("iPhone"));
    }

    @Given("user search for porcelain tea pot")
    public void user_search_for_porcelain_tea_pot() {
        googlePage.searchbox.sendKeys("porcelain tea pot",Keys.ENTER);

    }
    @Then("verify the page title contains porcelain tea pot")
    public void verify_the_page_title_contains_porcelain_tea_pot() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("porcelain"));

    }


    @Given("user search for {string}")
    public void user_search_for(String string) {
        googlePage.searchbox.sendKeys(string+Keys.ENTER);

    }


}
