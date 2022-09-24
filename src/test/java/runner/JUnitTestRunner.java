package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        glue = "steps"
        , monochrome = true
        , plugin = {"pretty",
        "json:target/cucumber-reports/AutomationReport.json"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
       , "json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter"

}
)

public class JUnitTestRunner {
}




