package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class OnlineStatements extends PageBase {

    public void clickYear(Integer yearText){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+yearText+"']"))).click();
        BrowserUtilities.wait(2);
    }

    public List<WebElement> getStatementList(String  year){
        switch (year){
            case "2012":
                return driver.findElements(By.xpath("(//tbody)[1]//tr"));
            case "2011":
                return driver.findElements(By.xpath("(//tbody)[2]//tr"));

            case "2010":
                return driver.findElements(By.xpath("(//tbody)[3]//tr"));
            default:
                return driver.findElements(By.xpath("(//tbody)[4]//tr"));
        }
    }

    public void clickStatement(String statement){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+statement+"']"))).click();
        BrowserUtilities.wait(2);
    }

    public void getDownloadedFile(String filename){
        File file = new File("/Users/semih/Downloads/8534567-31-11-09 (1).pdf"+filename);
        assert file.exists() : "File not downloaded";
    }


}
