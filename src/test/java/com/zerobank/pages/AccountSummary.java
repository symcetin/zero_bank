package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountSummary extends PageBase{

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

    @FindBy(xpath = "//div[@class='board'][3]//th")
    private List<WebElement> table;

    public List<String> getAccountTypes(){
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(accountTypes);
    }

    public List<WebElement> getCreditAccountsTable(){
        BrowserUtilities.waitForPageToLoad(20);
        return table;
    }


    public void clickAccount(String accountType){
        WebElement account = driver.findElement(By.xpath("//a[text()='"+accountType+"'][1]"));
        wait.until(ExpectedConditions.elementToBeClickable(account)).click();
    }


}
