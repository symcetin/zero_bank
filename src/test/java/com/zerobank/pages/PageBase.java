package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(className = "brand")
    protected WebElement pageSubtitle;

    @FindBy(id = "signin_button")
    protected WebElement signin_button;

    public PageBase(){
        PageFactory.initElements(driver,this);
    }

    public String getPageSubtitleText(){
        BrowserUtilities.waitForPageToLoad(10);
        return pageSubtitle.getText().trim();
    }
     public String getPageTitle(){
        BrowserUtilities.waitForPageToLoad(20);
        return driver.getTitle();
     }


    /**
     * Specify component name as a parameter, like: View all products or Orders
     * @param component
     */
    public void navigateTo(String component) {
        String locator = "//a[text()='" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    public void clickSigninButton(){
        BrowserUtilities.waitForPageToLoad(20);
        signin_button.click();
    }
}
