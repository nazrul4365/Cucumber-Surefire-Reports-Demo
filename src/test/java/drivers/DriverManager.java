package drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class DriverManager {
    protected abstract WebDriver initDriver();

    protected abstract WebDriver initDriver(String platform) throws MalformedURLException;

    public WebDriver getRemoteDriver(MutableCapabilities driverOptions) throws MalformedURLException {
        return new RemoteWebDriver(new URL("https://oauth-nazrul.phy.ru-a78a2:2fa97bb8-e86a-4cbf-8052-3799ba482fd6@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), driverOptions);
    }

    public DesiredCapabilities setBrowserType(String browserName, Platform platform) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browserName);
        desiredCapabilities.setPlatform(platform);
        return desiredCapabilities;
    }

    public Platform getPlatform(String platformName) {
        Platform platform;
        switch (platformName.toLowerCase()) {
            case "mac":
                platform = Platform.MAC;
                break;
            case "linux":
                platform = Platform.LINUX;
                break;
            case "windows":
            default:
                platform = Platform.WINDOWS;
                break;
        }
        return platform;
    }
}
