package base;

import configurations.Config;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import utils.TestContext;
import utils.TestUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;


public class BaseTest {
    public TestUtils testUtils;

    public static WebDriver driver;
    protected TestContext testContext;
    protected Config config;


    public BaseTest(TestContext testContext) throws URISyntaxException, IOException {
        this.config = Config.get_instance();
        this.testContext = testContext;
        this.testUtils = new TestUtils();

    }

    public WebDriver createDriver() throws URISyntaxException, IOException, IllegalAccessException, InterruptedException {
        driver = new DriverFactory().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(config.getBaseURL());
       // System.out.println("chrome");
        return driver;
    }


}
