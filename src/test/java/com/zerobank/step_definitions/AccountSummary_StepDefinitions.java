package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummary;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AccountSummary_StepDefinitions {
    AccountSummary accountSummary = new AccountSummary();
    @When("page title should be {string}")
    public void page_title_should_be(String title) {
      Assert.assertEquals(accountSummary.getPageTitle(),title);
    }

    @When("page should have to following:")
    public void page_should_have_to_following(List<String> dataTable) {
        System.out.println("Expected values: " + dataTable);
        Assert.assertEquals(dataTable, accountSummary.getAccountTypes());
    }

    @Then("Credit accounts table must have {string}, {string}, {string}")
    public void credit_accounts_table_must_have(String account, String creditCard, String balance) {
      Assert.assertEquals(accountSummary.getCreditAccountsTable().get(0).getText().trim(),account);
        Assert.assertEquals(accountSummary.getCreditAccountsTable().get(1).getText().trim(),creditCard);
        Assert.assertEquals(accountSummary.getCreditAccountsTable().get(2).getText().trim(),balance);
    }

}
