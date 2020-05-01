package com.zerobank.step_definitions;

import com.zerobank.pages.OnlineStatements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.File;

public class StatementsAndDocuments_StepDefinitions {
    OnlineStatements onlineStatements = new OnlineStatements();

    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        onlineStatements.navigateTo("Online Statements");
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        onlineStatements.clickYear(year);
    }


    @Then("{string} statements should be displayed for that {string}")
    public void statements_should_be_displayed_for_that(String statement, String year) {
        Assert.assertEquals(onlineStatements.getStatementList(year).size(),Integer.parseInt(statement));
    }


    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statement) {
        onlineStatements.clickStatement(statement);

    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String name) {
        File file = new File("/Users/semih/Downloads/8534567-"+name+".pdf");
        Assert.assertTrue(file.getName().contains(name));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        File file = new File("/Users/semih/Downloads/8534567-01-10-12.pdf");
        Assert.assertTrue(file.getName().endsWith(".pdf"));
    }



}
