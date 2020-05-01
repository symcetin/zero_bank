package com.zerobank.step_definitions;

import com.zerobank.pages.pay_bills.PaySavedPayee;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayBills_StepDefinitions {

    PaySavedPayee payBills = new PaySavedPayee();
    @Then("User should pay saved payee with following:")
    public void user_should_pay_saved_payee_with_following(Map<String,String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putAmount(dataTable.get("Amount"));
        payBills.putDate(dataTable.get("Date"));
        payBills.putDescription(dataTable.get("Description"));
    }

    @Then("User should click pay button")
    public void user_should_click_pay_button() {
        payBills.clickPay();
    }

    @Then("The success {string} should be displayed")
    public void the_success_should_be_displayed(String message) {
        Assert.assertTrue(payBills.getSuccessMessage(message).isDisplayed());
    }


    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {
        Assert.assertEquals(payBills.getSummary(),message);

    }

    @Then("User puts following:")
    public void user_puts_following(Map<String,String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putDescription(dataTable.get("Description"));
    }

}
