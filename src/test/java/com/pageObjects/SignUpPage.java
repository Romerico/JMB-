package com.pageObjects;

import com.base.BaseClass;
import com.mifmif.common.regex.Generex;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpPage extends BaseClass {

    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public SignUpPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    //locate a FirstName textbox
    @FindBy(xpath = "//input[@name=\"firstName\"]")
    @CacheLookup
    WebElement firstNameTextboxLocator;


    public void activateFirstNameTextbox() {
        firstNameTextboxLocator.sendKeys(Keys.TAB);
    }

    //enter the name with spaces into the textbox
    public void enterFirstNameWithSpaces() {

        firstNameTextboxLocator.sendKeys(BaseClass.randomestring() + "  ", Keys.TAB);
    }

    //enter the name with special characters
    public void enterFirstNameWithSpecChar() {
        firstNameTextboxLocator.sendKeys(BaseClass.randomestring() + "#", Keys.TAB);
    }

    //enter the name with special characters
    public void enterFirstNameWithNumber() {
        firstNameTextboxLocator.sendKeys(BaseClass.randomeNum(), Keys.TAB);
    }


    public void noLongerThan50Characters() {
        String random = RandomStringUtils.randomAlphabetic(50);
        firstNameTextboxLocator.sendKeys(random, Keys.TAB);
    }

    public void noLongerThan50CharactersNegative() {

        String random = RandomStringUtils.randomAlphabetic(51);
        firstNameTextboxLocator.sendKeys(random);
        String typedValue = firstNameTextboxLocator.getAttribute("value");
        int size = typedValue.length();

        if (size == 50) {
            softassert.assertTrue(true);
            System.out.println("Test passed! Max character functionality is working fine and is " + size);
        } else {
            System.out.println("Test failed! Max character value is other than required and is +" + size);
        }

    }

    //locate a LastName textbox
    @FindBy(xpath = "//input[@name=\"lastName\"]")
    @CacheLookup
    WebElement lastNameTextboxLocator;


    public void enterLastNameWithSpaces() {
        lastNameTextboxLocator.sendKeys(BaseClass.randomestring() + "  ", Keys.TAB);
    }

    public void enterLastNameWithSpecChar() {
        lastNameTextboxLocator.sendKeys(BaseClass.randomestring() + "#", Keys.TAB);
    }

    public void activateLastNameTextbox() {
        lastNameTextboxLocator.sendKeys(Keys.TAB);
    }

    public void noLongerThan50CharactersLastName() {
        String random = RandomStringUtils.randomAlphabetic(50);
        lastNameTextboxLocator.sendKeys(random, Keys.TAB);
    }

    public void noLongerThan50CharactersLastNameNegative() {

        String random = RandomStringUtils.randomAlphabetic(51);
        lastNameTextboxLocator.sendKeys(random);
        String typedValue = lastNameTextboxLocator.getAttribute("value");
        int size = typedValue.length();

        if (size == 50) {
            softassert.assertTrue(true);
            System.out.println("Test passed! Max character functionality is working fine and is " + size);
        } else {
            System.out.println("Test failed! Max character is other than required and is " + size);
        }
    }

    public void enterLastNameWithNumber() {
        lastNameTextboxLocator.sendKeys(BaseClass.randomeNum(), Keys.TAB);
    }

    //locate email textbox
    @FindBy(xpath = "//input[@name=\"email\"]")
    @CacheLookup
    WebElement emailTextBoxLocator;

    public void activateEmailTextbox() {
        emailTextBoxLocator.sendKeys(Keys.TAB);
    }

    public void passIrregularExp(){
        String random = RandomStringUtils.randomAlphabetic(50);

        emailTextBoxLocator.sendKeys(random, Keys.TAB);
    }

    public void passNolongerThan255(){
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(255);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        System.out.println("Passing :" + randomMail);

        String typedValue = emailTextBoxLocator.getAttribute("value");
        int size = typedValue.length();

        if (size == 255) {
            System.out.println("Test passed! Max character functionality is working fine and is " + size);
        } else {
            System.out.println("Test failed! Max character is other than required and is "+ size);
        }
    }

    public void passLongerThan255(){
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(260);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        System.out.println("Passing :" + randomMail);

//        String typedValue = emailTextBoxLocator.getAttribute("value");
//        int size = typedValue.length();
//
//        if (size == 255) {
//            System.out.println("Test passed! Max character functionality is working fine and is " + size);
//        } else {
//            System.out.println("Test failed! Max character is other than required and is "+ size);
//        }
    }


    public void passRegexMail(){
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random();

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        logger.info("Passing :" + randomMail);

    }
    //locate country code list
    @FindBy(xpath = "//div[@class=\"iti-arrow\"]")
    @CacheLookup
    WebElement countryCodeList;
    //locate phone textbox
    @FindBy(xpath = "//input[@id='phone']")
    @CacheLookup
    WebElement phoneTextbox;

    public void enterValidPhone() {
        String random = RandomStringUtils.randomNumeric(7);
        phoneTextbox.sendKeys("916" + random,Keys.TAB);
    }

    //locate passwordTextbox
    @FindBy(xpath = "//input[@id=\"password-field\"]")
    @CacheLookup
    WebElement passwordTextbox;

    public void enterValidPass(){
        String randomPass = RandomStringUtils.randomAlphanumeric(8);
        passwordTextbox.sendKeys(randomPass, Keys.TAB);

        logger.info("Passing :" + randomPass);
    }

    //locate consent label
    @FindBy(xpath = "//label[@for=\"candidateTosConsented\"]")
    @CacheLookup
    WebElement consentLabel;

    public void setConsentLabel(){
        consentLabel.click();
    }

    @FindBy(xpath = "//label[@for=\"candidatePpConsented\"]")
    @CacheLookup
    WebElement policyLabel;

    public void setPolicyLabel(){
        policyLabel.click();
    }

    @FindBy(xpath = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")
    @CacheLookup
    WebElement captchaLabel;

    public void setCaptchaLabel(){
        captchaLabel.click();
    }

    @FindBy(xpath = "//input[@type=\"submit\"]")
    @CacheLookup
    WebElement submitButton;

    public void setSubmitButton(){
        submitButton.click();
    }


    //locate the error message
    @FindBy(xpath = "//span[@class=\"help-block errorMsg\"]")
    @CacheLookup
    WebElement alert;

    //find the validation error
    public void findError() {

        try {
            if (alert.isDisplayed()) {
                logger.error("Test Failed!");

            }
        } catch (NoSuchElementException e) {
            System.out.println(e);
            logger.info("Test Passed!");

        }
    }

    public boolean findErrorB() throws NoSuchElementException{

        try {
            alert.isDisplayed();
            return true;


        }catch(NoSuchElementException ignored)
        {

        }
        finally
        {
            return false;
        }
    }




    //validate if the special symbol error message meets requirements
    public void validateError() {

        String actAlert = alert.getText();
        String expAlert = "Only character and spaces allowed";

        SoftAssert softassert = new SoftAssert();
            softassert.assertTrue(actAlert.equals(expAlert), "Test Passed! Validation message meets requirements :" + actAlert);
            //if message is the same as in the requirements

            logger.error("Test Failed! User gets different message, which is: " + actAlert);
        }



    //validate if the empty name error message meets requirements
    public void validateEmptyNameError() {

        String actAlert = alert.getText();
        String expAlert = "Please enter first name";

        SoftAssert softassert = new SoftAssert();
        if (actAlert.equals(expAlert)) {
            softassert.assertTrue(true);
            //if message is the same as in the requirements
            logger.info("Test Passed! User left the textbox empty and validation message meets requirements : " + actAlert);
        } else {
            logger.error("Test Failed! User gets different message, which is: " + actAlert);
        }


    }
    //validate if the empty last name error message meets requirements
    public void validateEmptyLastNameError() {

        String actAlert = alert.getText();
        String expAlert = "Please enter Last Name";

        SoftAssert softassert = new SoftAssert();
        if (actAlert.equals(expAlert)) {
            softassert.assertTrue(true);
            //if message is the same as in the requirements
            logger.info("Test Passed! User left the textbox empty and validation message meets requirements : " + actAlert);
        } else {
            logger.error("Test Failed! User gets different message, which is: " + actAlert);
        }
    }

    //validate if the empty email error message meets requirements

    public void validateEmailError() throws NoSuchElementException {
        try {
        String actAlert = alert.getText();
        String expAlert = "Please enter a valid email";

            SoftAssert softassert = new SoftAssert();
            if (actAlert.equals(expAlert)) {
                softassert.assertTrue(true);
                //if message is the same as in the requirements
                logger.info("Test Passed! Message meets requirements : " + actAlert);
            } else {
                logger.error("Test Failed! User gets different message : " + actAlert);
            }
        }
        catch(NoSuchElementException e) {
            logger.info("User did not get validation error message");
        }
        }
    }





