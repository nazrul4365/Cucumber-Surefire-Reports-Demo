package utils;


import base.BasePage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.*;


public class TestContext {
    private WebDriver driver;
    private Scenario scenario;
    private BasePage basePage;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private HomePage homePage;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public BasePage getBasePage() {return basePage;}
    public LandingPage getLandingPage() {
        return landingPage;
    }
    public LogInPage getLogInPage() {
        return logInPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }



    public void initializePageObjectClass() {
        driver = getDriver();
        basePage = new BasePage(driver,scenario);
        landingPage = new LandingPage(driver,scenario);
        homePage = new HomePage(driver,scenario);
        logInPage = new LogInPage(driver,scenario);
      }


}
