package pages;

import base.BasePage;
import configurations.User;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class LogInPage extends BasePage {
    private final By emailFld = By.name("email");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("commit");
    private final By errMessage = By.cssSelector("div.bodySmall");

    public LogInPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public LogInPage enterEmailFld(String useName){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFld));
        e.clear();
        e.sendKeys(useName);
        return this;
    }
    public LogInPage enterPasswordFld(String password){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld));
        e.clear();
        e.sendKeys(password);
        return this;
    }
    public HomePage clickLoginBtn(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        e.click();
        return new HomePage(driver,scenario);
    }
    public String getErrMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errMessage)).getText();
    }
}
