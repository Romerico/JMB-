package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CA_infoPages extends BaseClass {


    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public CA_infoPages(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    //locate title
    @FindBy(xpath = "//div[@class=\"loginForm_section clearfix\"]/h2")
    @CacheLookup
    WebElement lookingforjobTitle;

    public static boolean infoPageTitle(String locator, String title) {
        return driver.findElement(By.xpath(locator)).getText().equals(title);
    }

    public String actInfoTitle(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }


}
