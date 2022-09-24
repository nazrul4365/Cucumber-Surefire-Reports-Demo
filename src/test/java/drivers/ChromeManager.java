package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class ChromeManager extends DriverManager {
    private static final String BROWSER_NAME = "chrome";

    @Override
    protected WebDriver initDriver() {
        ChromeOptions options = setOption();
        /* Uncomment Arguments when running test in headless mode */
        // options.addArguments("headless");
        return new ChromeDriver(options);
    }


    @Override
    protected WebDriver initDriver(String platformName) throws MalformedURLException {
        ChromeOptions options = setOption();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");
        Platform platform = getPlatform(platformName);
        DesiredCapabilities capabilities = setBrowserType(BROWSER_NAME, platform);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        return getRemoteDriver(options);
    }

    private ChromeOptions setOption() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--disable-notifications");

        return new ChromeOptions();
    }
}
