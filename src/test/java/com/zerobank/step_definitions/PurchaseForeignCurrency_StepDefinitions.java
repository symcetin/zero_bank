package com.zerobank.step_definitions;

import com.zerobank.pages.pay_bills.PurchaseForeignCurrency;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrency_StepDefinitions {

    PurchaseForeignCurrency foreignCurrency = new PurchaseForeignCurrency();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Assert.assertEquals(dataTable, foreignCurrency.getCurrencies());
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        foreignCurrency.putAmount("123");
        foreignCurrency.clickCalculateCosts();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String message = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(foreignCurrency.getPopup(),message);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        foreignCurrency.clickCalculateCosts();

    }

}
