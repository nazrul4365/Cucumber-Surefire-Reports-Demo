package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = "steps"
        , monochrome = true
        , plugin = {"pretty"
        ,"summary"
        ,"json:target/cucumber-reports/cucumber.json"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        , "json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter"
}
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
}




