package steps;

import base.BaseTest;
import configurations.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class LoginSteps extends BaseTest {

    public LoginSteps(TestContext testContext) throws URISyntaxException, IOException {
        super(testContext);
    }

    @Given("^Landing page is present$")
    public void landingPageIsPresent() {
        testContext.getLandingPage().NavigateToHomePage(config.getBaseURL());
        testUtils.log().info("The URL is successfully initialized");
    }


    @When("^I hit login button$")
    public void iClickLoginButton() {
        testContext.getLandingPage().clickLoginBtn();

    }

    @And("^Enter valid email and password$")
    public void enterValidEmailAndPassword() {
        User user = Arrays.stream(config.getConfigUsers()).findAny().get();
        testContext.
                getLogInPage().
                enterEmailFld(user.getUserName()).
                enterPasswordFld(user.getPassword());
        testUtils.log().info("Data has been fetched from config.jsonData fetch from config.json ");
    }

    @And("^I click LogIn button$")
    public void iClickLogInButton() {
        testContext.getLogInPage().clickLoginBtn();

    }

    @Then("^I should see HomePage title is \"([^\"]*)\"$")
    public void iShouldSeeHomePageTitleIs(String expected) throws InterruptedException {
        String actualTitle = testContext.getHomePage().getPageTitle();
        Thread.sleep(100);
        Assert.assertEquals(actualTitle, expected);
        testUtils.log().info("Assertion is done");
    }


    @And("^I enter  (.+) and (.+)$")
    public void iEnterUserNameAndPassWord(String userName, String passWord) {
        testContext.
                getLogInPage().
                enterEmailFld(userName).enterPasswordFld(passWord);
    }

    @Then("^login should fail with an error \"([^\"]*)\"$")
    public void loginShouldFailWithAnError(String expectedTitle) throws InterruptedException {
        String actualTitle = testContext.getLogInPage().getErrMessage();
        Thread.sleep(100);
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}


