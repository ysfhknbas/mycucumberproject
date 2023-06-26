package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefs {

    WebDriver driver ;
    @Given("user is on the {string} url on {string} browser")
    public void user_is_on_the_url_on_browser(String url, String browser) throws MalformedURLException {

        URL remoteURL = new URL("http://192.168.137.1:4444");
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(remoteURL, new ChromeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }else if(browser.equalsIgnoreCase("edge")){
            driver = new RemoteWebDriver(remoteURL, new EdgeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        driver.get(url);
    }
    @Then("verify the page title contains {string} on grid")
    public void verify_the_page_title_contains_on_grid(String keyWord) {
        Assert.assertTrue(driver.getTitle().contains(keyWord));

    }

    @Then("close the remote driver")
    public void close_the_remote_driver() {

        driver.quit();
    }
}
