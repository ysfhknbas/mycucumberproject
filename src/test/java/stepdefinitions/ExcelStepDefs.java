package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.BRHomePage;
import pages.BRLoginPage;
import utilities.*;

import java.util.List;
import java.util.Map;

public class ExcelStepDefs {
    BRHomePage brHomePage = new BRHomePage();
    BRLoginPage brLoginPage = new BRLoginPage();

    List<Map<String,String>> datalist;
    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) {

        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = sheet;
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        datalist = excelUtils.getDataList();

        for (Map<String,String> eachdata : datalist) {
            Driver.getDriver().get(ConfigReader.getProperty("br_url"));
            brHomePage.homeLoginLink.click();
            WaitUtils.waitFor(1);
            brLoginPage.userEmail.sendKeys(eachdata.get("username"));
            WaitUtils.waitFor(1);
            brLoginPage.userPass.sendKeys(eachdata.get("password"));
            WaitUtils.waitFor(1);
            brLoginPage.loginButton.click();
            WaitUtils.waitFor(1);
            ReusableMethods.verifyElementDisplayed(brHomePage.userID);
            WaitUtils.waitFor(1);
            brHomePage.userID.click();
            WaitUtils.waitFor(1);
            brHomePage.logOut.click();
            WaitUtils.waitFor(1);
            brHomePage.OK.click();
            WaitUtils.waitFor(1);
        }
           Driver.closeDriver();
    }
}
