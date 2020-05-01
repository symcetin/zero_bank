package com.zerobank.pages.pay_bills;

import com.zerobank.pages.PageBase;
import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrency extends PageBase {

    @FindBy(id = "pc_currency")
    private WebElement currency;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCosts;

    @FindBy(id = "pc_amount")
    private WebElement amount_currency;



    public void putAmount(String amount){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(amount_currency));
        amount_currency.sendKeys(amount);
    }

    public List<String> getCurrencies(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(currency));
        Select currencySelect = new Select(currency);
        List<WebElement> list = currencySelect.getOptions();
        list.remove(0);
        return BrowserUtilities.getTextFromWebElements(list);
    }

    public void clickCalculateCosts(){
        wait.until(ExpectedConditions.elementToBeClickable(calculateCosts)).click();
    }

    public String getPopup(){
        Alert alert=driver.switchTo().alert();
        BrowserUtilities.wait(2);
        return alert.getText();

    }


}

