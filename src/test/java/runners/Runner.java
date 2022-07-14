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
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "./src/test/resources/features",//MUST
        glue = "stepdefinitions",//MUST
<<<<<<< HEAD
        tags = "@GetTheAppointments",


=======
        tags ="@US003_TC05",
>>>>>>> 98d48eea5611fdcdca42871e7baddb006f7bfee3
        dryRun =false

)
public class Runner {
}
