package pages;

import base.BasePage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {
    private final By loginBtn = By.cssSelector("a.register-btn");

    public LandingPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);

    }

    public void NavigateToHomePage(String url) {
        driver.get(url);
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }

}
