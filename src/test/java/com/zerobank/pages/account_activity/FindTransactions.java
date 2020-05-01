package com.zerobank.pages.account_activity;

import com.zerobank.pages.PageBase;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactions extends AccountActivity {
    @FindBy(id = "aa_description")
    private WebElement description;

    @FindBy(id = "aa_fromDate")
    private WebElement fromDate;

    @FindBy(id = "aa_toDate")
    private WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    private WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    private WebElement toAmount;

    @FindBy(id = "aa_type")
    private WebElement type;

    @FindBy(xpath = "//button[text()='Find']")
    private WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    private List<WebElement> listDescription;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    private List<WebElement> listDates;

    @FindBy(xpath = "//div[contains(text(),'No results.')]")
    private WebElement result;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    private List<WebElement> deposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    private List<WebElement> withdrawal;

    public void putDescription(String descriptionText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(description));
        description.clear();
        description.sendKeys(descriptionText);
        BrowserUtilities.wait(2);
    }

    public void putFromDate(String dateText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(fromDate));
        fromDate.clear();
        fromDate.sendKeys(dateText);
        BrowserUtilities.wait(2);
    }

    public void putToDate(String dateText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(toDate));
        toDate.clear();
        toDate.sendKeys(dateText);
        BrowserUtilities.wait(2);
    }

    public void putFromAmount(String amountText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(fromAmount));
        fromAmount.clear();
        fromAmount.sendKeys(amountText);
        BrowserUtilities.wait(2);
    }

    public String getFromDate(){
        wait.until(ExpectedConditions.visibilityOf(fromDate));
        return fromDate.getAttribute("value");
    }

    public String getToDate(){
        wait.until(ExpectedConditions.visibilityOf(toDate));
        return toDate.getAttribute("value");
    }

    public void putToAmount(String amountText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(toAmount));
        toAmount.clear();
        toAmount.sendKeys(amountText);
        BrowserUtilities.wait(2);
    }


    public void selectType(String typeText){
        BrowserUtilities.waitForPageToLoad(20);
        Select accountSelect = new Select(type);
        accountSelect.selectByVisibleText(typeText);
        BrowserUtilities.wait(2);
    }

    public void clickFind(){
        wait.until(ExpectedConditions.elementToBeClickable(find)).click();
        BrowserUtilities.wait(2);
    }

    public List<String> getListDescription(){
        return BrowserUtilities.getTextFromWebElements(listDescription);
    }

    public List<String> getListDates(){
        return BrowserUtilities.getTextFromWebElements(listDates);
    }

    public String getResult(){
        wait.until(ExpectedConditions.visibilityOf(result));
        return result.getText().trim();
    }

    public List<String> getDeposit(){
        return BrowserUtilities.getTextFromWebElements(deposit);
    }

    public List<String> getWithdrawal(){
       // wait.until(ExpectedConditions.visibilityOf(withdrawal));
        return BrowserUtilities.getTextFromWebElements(withdrawal);
    }

}
