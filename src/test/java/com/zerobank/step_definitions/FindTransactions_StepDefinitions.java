package com.zerobank.step_definitions;

import com.zerobank.pages.account_activity.FindTransactions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactions_StepDefinitions {

    FindTransactions findTransactions = new FindTransactions();

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
       findTransactions.putFromDate(date1);
       findTransactions.putToDate(date2);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactions.clickFind();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String date1, String date2) {
        Assert.assertEquals(date1, findTransactions.getFromDate());
        Assert.assertEquals(date2, findTransactions.getToDate());
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        int date1 = Integer.parseInt(findTransactions.getListDates().get(0).replace("-",""));
        int date2 = Integer.parseInt(findTransactions.getListDates().get(1).replace("-",""));
        Assert.assertTrue(date1>date2);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Assert.assertFalse(findTransactions.getListDates().contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        findTransactions.putDescription(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        for (String each :  findTransactions.getListDescription()) {
            Assert.assertTrue(each.contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        for (String each :  findTransactions.getListDescription()) {
            Assert.assertFalse(each.contains(description));
        }
    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(findTransactions.getDeposit().size()>0);

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(findTransactions.getWithdrawal().size()>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        findTransactions.selectType(type);
        findTransactions.clickFind();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        System.out.println(findTransactions.getWithdrawal());
        Assert.assertEquals(0,findTransactions.getWithdrawal().size());

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertEquals(0,findTransactions.getDeposit().size());
    }


}
