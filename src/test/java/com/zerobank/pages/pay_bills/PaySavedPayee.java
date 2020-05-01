package com.zerobank.pages.pay_bills;

import com.zerobank.pages.PageBase;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PaySavedPayee extends PageBase {

    @FindBy(id = "sp_payee")
    private WebElement payee;

    @FindBy(id = "sp_account")
    private WebElement account;

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(id = "pay_saved_payees")
    private WebElement pay;


    public void selectPayee(String option){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payee));
        Select select = new Select(payee);
        select.selectByVisibleText(option);
    }

    public void selectAccount(String option){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(account));
        Select select = new Select(account);
        select.selectByVisibleText(option);
    }

    public void putAmount(String number){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(amount));
        amount.sendKeys(number);
    }

    public void putDate(String dateText){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(date));
        date.sendKeys(dateText);
    }

    public void putDescription(String text){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(description));
        description.sendKeys(text);
    }

    public WebElement getSuccessMessage(String text){
        WebElement message = driver.findElement(By.xpath("//span[text()='"+text+"']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message;
    }

    public void clickPay(){
        wait.until(ExpectedConditions.elementToBeClickable(pay)).click();
    }


    public String getSummary(){
        return driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
    }
}
