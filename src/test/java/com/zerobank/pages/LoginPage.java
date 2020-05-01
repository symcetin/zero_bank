package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends PageBase{

    @FindBy(id = "user_login")
    private WebElement username;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(id = "user_remember_me")
    private WebElement rememberMe;

    @FindBy(css = "[value='Sign in']")
    private WebElement sign_in;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    @FindBy(xpath = "//a[text()='Forgot your password ?']")
    private WebElement forgotPassword;


    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        clickSigninButton();
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login() {
        clickSigninButton();
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }




}
