package com.zerobank.pages.pay_bills;

import com.zerobank.pages.PageBase;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewPayee extends PageBase {

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement add;

    public void putPayeeName(String name){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeName));
        payeeName.sendKeys(name);
        BrowserUtilities.wait(2);
    }

    public void putPayeeAddress(String address){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeAddress));
        payeeAddress.sendKeys(address);
        BrowserUtilities.wait(2);
    }

    public void putPayeeAccount(String account){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeAccount));
        payeeAccount.sendKeys(account);
        BrowserUtilities.wait(2);
    }

    public void putPayeeDetails(String details){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeDetails));
        payeeDetails.sendKeys(details);
        BrowserUtilities.wait(2);
    }

    public void clickAdd(){
        wait.until(ExpectedConditions.elementToBeClickable(add)).click();
    }


    public String getSummary(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String getSuccessMessage(){
        WebElement message = driver.findElement(By.id("alert_content"));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }


}
