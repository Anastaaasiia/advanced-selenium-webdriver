package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private By logOutLocator = By.xpath("//a[@class='button secondary radius']");
    private By successMsgLocator = By.id("flash");
    private String pageUrl = "http://the-internet.herokuapp.com/secure";

    public String getPageUrl() {
        return pageUrl;
    }

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Return true if element is visible on the page */
    public boolean isLogOutVisible(){
        return find(logOutLocator).isDisplayed();
    }

    /** Return text from element by given locator */
    public String getSuccessMsg(){
        return find(successMsgLocator).getText();
    }

}
