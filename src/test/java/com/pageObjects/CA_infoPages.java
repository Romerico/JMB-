package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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
    static
    WebElement lookingforjobTitle;

    public boolean infoPageTitle(String title) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("lookingforjobTitle")));

        return lookingforjobTitle.getText().equals(title);
    }

    public String actInfoTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("lookingforjobTitle")));

        return lookingforjobTitle.getText();
    }


}
