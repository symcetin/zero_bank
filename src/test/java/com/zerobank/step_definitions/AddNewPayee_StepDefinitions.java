package com.zerobank.step_definitions;

import com.zerobank.pages.pay_bills.AddNewPayee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayee_StepDefinitions {

    AddNewPayee addNewPayee = new AddNewPayee();

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        addNewPayee.putPayeeName(dataTable.get("Payee Name"));
        addNewPayee.putPayeeAddress(dataTable.get("Payee Address"));
        addNewPayee.putPayeeAccount(dataTable.get("Account"));
        addNewPayee.putPayeeDetails(dataTable.get("Payee Details"));
        addNewPayee.clickAdd();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
       // Assert.assertTrue(addNewPayee.getSummary(message).isDisplayed());

        Assert.assertEquals(addNewPayee.getSummary(),message);
    }

}
