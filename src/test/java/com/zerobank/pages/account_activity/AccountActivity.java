package com.zerobank.pages.account_activity;

import com.zerobank.pages.PageBase;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity extends PageBase {

    @FindBy(id = "aa_accountId")
    protected WebElement account;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    private List<WebElement> transactionTable;


    public String getDefaultAccount(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(account));
        Select accountSelect = new Select(account);
        return accountSelect.getFirstSelectedOption().getText().trim();
    }

    public List<String> getDefaultAccountOptions(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(account));
        Select accountSelect = new Select(account);
        List<WebElement> list = accountSelect.getOptions();
        list.remove(0);
        return BrowserUtilities.getTextFromWebElements(list);
    }

    public List<String> getTransactionTable(){
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(transactionTable);
    }


    public void selectAccount(String accountText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(account));
        Select accountSelect = new Select(account);
        accountSelect.selectByVisibleText(accountText);
        BrowserUtilities.wait(2);
    }




}
