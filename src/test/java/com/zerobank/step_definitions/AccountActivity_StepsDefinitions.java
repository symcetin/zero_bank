package com.zerobank.step_definitions;

import com.zerobank.pages.account_activity.AccountActivity;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivity_StepsDefinitions {

    AccountActivity accountActivity = new AccountActivity();

    @Then("User navigates to {string}")
    public void user_navigates_to(String module) {
        accountActivity.navigateTo(module);
    }

    @Then("Default drop down option should be {string}")
    public void default_drop_down_option_should_be(String defaultAccount) {
        Assert.assertEquals(accountActivity.getDefaultAccount(),defaultAccount);
    }


    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> dataTable) {
        Assert.assertEquals(dataTable,accountActivity.getDefaultAccountOptions());
    }

    @Then("Transactions table should have column names {string}, {string}, {string}, {string}")
    public void transactions_table_should_have_column_names(String date, String description, String deposit, String withdrawal) {
        String[] arr ={date, description, deposit, withdrawal};
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(accountActivity.getTransactionTable().get(i),arr[i]);
        }
    }


}
