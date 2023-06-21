package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true,
        features = "./src/test/resources/features",
        glue = {"stepdefinitions"},
        dryRun = false, // (true) gives only missing steps - (false) default
        tags = "@test_runner"// run only this

)
public class TestRunner {

}
/*
parameterizing_with
*/
