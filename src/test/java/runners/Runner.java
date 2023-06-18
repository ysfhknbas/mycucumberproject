package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        dryRun = false, // (true) gives only missing steps - (false) default
        tags = "@parameterizing" // run only this
)
public class Runner {

}
