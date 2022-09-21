package com.pageObjects;

import com.base.BaseClass;
import com.mifmif.common.regex.Generex;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class CA_VerifyMobile extends BaseClass {


    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public CA_VerifyMobile(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    //locate error message
    @FindBy(xpath = "//span[@class=\"errorMsg errMszClass\"]")
    @CacheLookup
    WebElement mobileError;

    //find the validation error
    public boolean mobileErrorisDisplayed(){
        return mobileError.isDisplayed();
    }
    public String errorText(){

        return mobileError.getText();
    }
    //locate OTP textboxes
    @FindBy(xpath = "//div[@class=\"pincode-input-container\"]/input[@maxlength=\"1\"]")
    @CacheLookup
    List<WebElement> mobileTextbox;

    public void passValidNumbersMobile() {
        java.util.List<WebElement> text = mobileTextbox;
        int i;
        int j = 1;

        for (i = 0; i < text.size(); i++) {

            String code = String.valueOf(j++);
            text.get(i).sendKeys(code);

        }
    }

    public void passCharsMobile() {
        java.util.List<WebElement> text = mobileTextbox;

        Generex gen = new Generex("(a-z)");
        String randomNumber = gen.random(1);

        for (WebElement textbox : text) {
            textbox.sendKeys(randomNumber);

        }
    }
    //locate submit button
    @FindBy(xpath = "//input[@id=\"sbBt\"]")
    @CacheLookup
    WebElement submitBtn;

    public void hitSubmit(){
        submitBtn.click();
    }






}
