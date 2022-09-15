package com.pageObjects;

import com.base.BaseClass;
import com.mifmif.common.regex.Generex;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
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
            logger.info("Test passed! Max character functionality is working fine and is " + size);
        } else {
            logger.error("Test failed! Max character value is other than required and is +" + size);
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
            logger.info("Test passed! Max character functionality is working fine and is " + size);
        } else {
            logger.error("Test failed! Max character is other than required and is " + size);
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
            logger.info("Test passed! Max character functionality is working fine and is " + size);
        } else {
            logger.error("Test failed! Max character is other than required and is "+ size);
        }
    }

    public void passLongerThan255(){
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(260);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        logger.info("Passing :" + randomMail);

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

    public void activatePhoneTextbox(){
        phoneTextbox.sendKeys(Keys.TAB);
    }

    public void enterValidPhone() {
        String random = RandomStringUtils.randomNumeric(7);
        phoneTextbox.sendKeys("916" + random,Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneLessThan10() {
        String random = RandomStringUtils.randomNumeric(5);
        phoneTextbox.sendKeys("916" + random,Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneMoreThan10() {
        String random = RandomStringUtils.randomNumeric(8);
        phoneTextbox.sendKeys("916" + random,Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneSpaceHyphen() {
        String random = RandomStringUtils.randomNumeric(7);
        phoneTextbox.sendKeys("916", "-" + random," ",Keys.TAB);
        logger.info("passing " + random);
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

    public void enterStrongPass(){
        Generex gen = new Generex("([a-z0-9]+)([#, @, -, _, !, ?]+)");
        String randomPass = gen.random(6);

        passwordTextbox.sendKeys(randomPass);

        logger.info("Passing : " + randomPass);
    }

    public void enterStrongPass2(){
        Generex gen = new Generex("([a-zA-Z0-9 # @ - _ ! ?]+)");
        String randomPass = gen.random(6);

        passwordTextbox.sendKeys(randomPass);

        logger.info("Passing : " + randomPass);
    }


    public void enterEmptyPass(){

        passwordTextbox.sendKeys(Keys.TAB);

    }



    //locate consent label
    @FindBy(xpath = "//a[@href=\"/about-jombone#terms\"]")
    @CacheLookup
    WebElement consentLink;


    public void clickConsentLink() {
        consentLink.click();

    }


    @FindBy(xpath = "//a[@href=\"/about-jombone#privacy\"]")
    @CacheLookup
    WebElement policyLink;

    public void clickPolicyLink(){
        policyLink.click();
    }

    public void switchToWindow(String windowId){
        driver.switchTo().window(windowId);
    }

    public void switchToPopUpTab() {
        String parentWindowId = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowId)) {
                switchToWindow(handle);
            }
        }
    }

    public boolean pageTitle(String locator, String title){
        return driver.findElement(By.xpath(locator)).getText().equals(title);
    }

    public String actTitle(String locator){
        return driver.findElement(By.xpath(locator)).getText();
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
    public void findError(String tname) {

        try {
            if (alert.isDisplayed()) {
                logger.error("Test Failed!");
                captureScreen(driver,tname);


            }
        } catch (NoSuchElementException | IOException e) {
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


    //validate if the error message meets requirements

    public void validateErrorMessage(String expAlert,  String tname) {

        try {
            String actAlert = alert.getText();

            SoftAssert softassert = new SoftAssert();
            if (actAlert.equals(expAlert)) {
                softassert.assertTrue(true);
                //if message is the same as in the requirements
                logger.info("Test Passed! Message meets requirements : " + actAlert);
            } else {
                logger.error("Test Failed! User gets different message : " + actAlert);
                captureScreen(driver,tname);
            }
        }
        catch(NoSuchElementException | IOException e) {
            logger.info("User did not get validation error message");
        }
    }
    }





