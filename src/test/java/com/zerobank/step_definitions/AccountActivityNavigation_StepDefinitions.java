package com.zerobank.step_definitions;

import com.zerobank.pages.account_activity.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigation_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    AccountSummary accountSummary = new AccountSummary();
    AccountActivity accountActivity = new AccountActivity();

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.login();
    }

    @When("The user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
        accountSummary.clickAccount(accountType);
    }

    @Then("The {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
        Assert.assertEquals(accountActivity.getPageTitle(), "Zero - "+page);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String account) {
        Assert.assertEquals(accountActivity.getDefaultAccount(), account);
    }






}
