package drivers;

import configurations.Config;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

public class DriverFactory {

    public WebDriver create() throws URISyntaxException, IOException, IllegalAccessException, InterruptedException {
        Config config = Config.get_instance();
        String browserName = config.getConfigDriver().getBrowser();
        String platformName = config.getConfigDriver().getPlatform();

        DriverManager driverManager = getDriverManager(browserName);
        WebDriver driver = config.getConfigDriver().isRemote() ? driverManager.initDriver(platformName) : driverManager.initDriver();
        return driver;
    }

    private DriverManager getDriverManager(String browserType) throws IllegalAccessException, InterruptedException {
        DriverManager driverManager;
        switch (browserType.toLowerCase()) {
            case "chrome":
                driverManager = new ChromeManager();
                break;
            case "firefox":
                driverManager = new FirefoxManager();
                break;
            default:
                throw new IllegalAccessException("Invalid browser name" + browserType);
        }
        Thread.sleep(300);
        return driverManager;
    }

}
