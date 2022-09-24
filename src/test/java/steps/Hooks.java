package steps;


import base.BaseTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class Hooks extends BaseTest {

    public Hooks(TestContext testContext) throws URISyntaxException, IOException {
        super(testContext);
    }

   @Before
    public void beforeTest(Scenario scenario) throws URISyntaxException, IOException, IllegalAccessException, InterruptedException {

       this.driver = createDriver();
       testContext.setDriver(driver);
       testContext.setScenario(scenario);
       testContext.initializePageObjectClass();

   }

   @After
   public void afterTest()  {
       Scenario scenario = testContext.getScenario();
       //validate if scenario has failed
       if(scenario.isFailed()) {
           final byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenario.getName());
       }


       if (driver !=null){
           driver.quit();
       }

   }



   @BeforeStep
   public void beforeStep(){

   }
   @AfterStep
    public void afterStep(){

   }
}
