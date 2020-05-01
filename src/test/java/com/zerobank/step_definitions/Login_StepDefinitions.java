package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {


    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
      Assert.assertEquals(loginPage.getPageTitle(), title);
    }

    @When("User logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        loginPage.login("useruser","12345");
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
        Assert.assertEquals(loginPage.getWarningMessageText(),"Login and/or password are wrong.");
    }

}
