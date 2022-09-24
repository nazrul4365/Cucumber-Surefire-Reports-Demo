package pages;

import base.BasePage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
