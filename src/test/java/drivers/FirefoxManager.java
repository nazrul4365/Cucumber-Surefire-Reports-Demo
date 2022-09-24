package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;


public class FirefoxManager extends DriverManager {


    private static final String BROWSER_NAME = "firefox";

    @Override
    protected WebDriver initDriver() {
        FirefoxOptions options = setOption();
        /* Uncomment Arguments when running test in headless mode */
        //options.setHeadless(true);
        return new FirefoxDriver(options);

    }

    @Override
    protected WebDriver initDriver(String platformName) throws MalformedURLException {
        FirefoxOptions options = setOption();
        Platform platform = getPlatform(platformName);
        DesiredCapabilities capabilities = setBrowserType(BROWSER_NAME, platform);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        options.merge(capabilities);
        return getRemoteDriver(options);
    }

    private FirefoxOptions setOption() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Asus\\IdeaProjects\\e-commerce e2e demo framework-cucumber-testng\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("dom.webnotifications.enabled", false);
        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("marionatte", true);
        firefoxOptions.merge(dc);

        return new FirefoxOptions(firefoxOptions);
    }

}
