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
<<<<<<< HEAD
        tags = "@team87",
=======
        tags = "@US14",
>>>>>>> 4283bdcd1b414d88986f9503ce11174d4cff2499
=======
        tags = "@US14",
>>>>>>> 4283bdcd1b414d88986f9503ce11174d4cff2499
        dryRun = false


)
public class Runner {
}
