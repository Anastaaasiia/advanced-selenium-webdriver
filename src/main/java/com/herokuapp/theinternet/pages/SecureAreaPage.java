package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private By logOutLocator = By.xpath("//a[@class='button secondary radius']");
    private By successMsgLocator = By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Return true if element is visible on the page */
    protected boolean isLogOutVisible(){
        return find(logOutLocator).isDisplayed();
    }

    /** Return text from element by given locator */
    protected String getSuccessMsg(By locator){
        return find(successMsgLocator).getText();
    }

}
