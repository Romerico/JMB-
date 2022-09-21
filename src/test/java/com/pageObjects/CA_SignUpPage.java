package com.pageObjects;

import com.base.BaseClass;
import com.mifmif.common.regex.Generex;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;


public class CA_SignUpPage extends BaseClass {

    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public CA_SignUpPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    //Terms and conditions by the element of an actual title of a page
    @FindBy(xpath = "//div[@id='terms']/h2")
    @CacheLookup
    WebElement TERMS;

    public boolean pageTitle(String title) {
        return TERMS.getText().equals(title);
    }

    public String actTitle() {
       return TERMS.getText();
    }

    //Privacy Policy by the element of an actual title of a page
    @FindBy(xpath = "//div[@id='privacy']/h2")
    @CacheLookup
    WebElement POLICY;

    public boolean pageTitleP(String title) {
        return POLICY.getText().equals(title);
    }

    public String actTitleP() {
        return POLICY.getText();
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

    public void passIrregularExp() {
        String random = RandomStringUtils.randomAlphabetic(50);

        emailTextBoxLocator.sendKeys(random, Keys.TAB);
    }

    public void passNolongerThan255() {
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(255);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        System.out.println("Passing :" + randomMail);

        String typedValue = emailTextBoxLocator.getAttribute("value");
        int size = typedValue.length();

        if (size == 255) {
            logger.info("Max character functionality is working fine and is " + size);
        } else {
            logger.error("Max character is other than required and is " + size);
        }
    }

    public void passLongerThan255() {
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(260);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        logger.info("Passing :" + randomMail);

        String typedValue = emailTextBoxLocator.getAttribute("value");
        int size = typedValue.length();

        if (size == 255) {
            System.out.println("Max character functionality is working fine and is " + size);
        } else {
            System.out.println("Max character is other than required and is " + size);
        }
    }


    public void passRegexMail() {
        Generex gen = new Generex("([a-z0-9]+)[@]([a-z0-9]+)[.]([a-z0-9]+)");
        String randomMail = gen.random(10);

        emailTextBoxLocator.sendKeys(randomMail, Keys.TAB);
        logger.info("Passing :" + randomMail);

    }

    //locate country code list
    @FindBy(xpath = "//div[@class=\"iti-arrow\"]")
    @CacheLookup
    WebElement countryCodeList;

    public void chooseNotCanada() {
        countryCodeList.click();
        driver.findElement(By.xpath("//li[@data-dial-code=\"376\"]")).click();

    }

    //locate phone textbox
    @FindBy(xpath = "//input[@id='phone']")
    @CacheLookup
    WebElement phoneTextbox;

    public void activatePhoneTextbox() {
        phoneTextbox.sendKeys(Keys.TAB);
    }

    public void enterValidPhone() {
        String random = RandomStringUtils.randomNumeric(7);
        phoneTextbox.sendKeys("916" + random, Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneLessThan10() {
        String random = RandomStringUtils.randomNumeric(5);
        phoneTextbox.sendKeys("916" + random, Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneMoreThan10() {
        String random = RandomStringUtils.randomNumeric(8);
        phoneTextbox.sendKeys("916" + random, Keys.TAB);
        logger.info("passing " + random);
    }

    public void enterPhoneSpaceHyphen() {
        String random = RandomStringUtils.randomNumeric(7);
        phoneTextbox.sendKeys("916", "-" + random, " ", Keys.TAB);
        logger.info("passing " + random);
    }

    //locate passwordTextbox
    @FindBy(xpath = "//input[@id=\"password-field\"]")
    @CacheLookup
    WebElement passwordTextbox;

    public void enterValidPass() {
        String randomPass = RandomStringUtils.randomAlphanumeric(8);
        passwordTextbox.sendKeys(randomPass, Keys.TAB);

        logger.info("Passing :" + randomPass);
    }

    public void enterStrongPass() {
        Generex gen = new Generex("([a-z0-9]+)([#, @, -, _, !, ?]+)");
        String randomPass = gen.random(6);

        passwordTextbox.sendKeys(randomPass);

        logger.info("Passing : " + randomPass);
    }

    public void enterStrongPass2() {
        Generex gen = new Generex("([a-zA-Z0-9 # @ - _ ! ?]+)");
        String randomPass = gen.random(6);

        passwordTextbox.sendKeys(randomPass);

        logger.info("Passing : " + randomPass);
    }


    public void enterEmptyPass() {

        passwordTextbox.sendKeys(Keys.TAB);

    }


    //locate consent link
    @FindBy(xpath = "//a[@href=\"/about-jombone#terms\"]")
    @CacheLookup
    WebElement consentLink;


    public void clickConsentLink() {
        consentLink.click();

    }
    //locate terms checkbox
    @FindBy(xpath = "//label[@for=\"candidateTosConsented\"]")
    @CacheLookup
    WebElement consentCheckbox;

    public void consentLabelClick() {
        consentCheckbox.click();
    }
    //locate policy checkbox
    @FindBy(xpath = "//label[@for=\"candidatePpConsented\"]")
    @CacheLookup
    WebElement policyCheckbox;

    public void policylableClick() {
        policyCheckbox.click();
    }

    //locate policy link
    @FindBy(xpath = "//a[@href=\"/about-jombone#privacy\"]")
    @CacheLookup
    WebElement policyLink;

    public void clickPolicyLink() {
        policyLink.click();
    }

    public void switchToWindow(String windowId) {
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


    //locate captcha label
    @FindBy(xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
    @CacheLookup
    WebElement captchaLabel;

    public void clickCaptchaLabel() throws NoSuchElementException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                captchaLabel));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']"))).click();
        //adding wait to either pass the captcha manually or if it is checked, then just proceed
        FluentWait wait1 = new FluentWait(driver);
        wait1.withTimeout(Duration.ofSeconds(15));
        wait1.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-checked=\"true\"]")));

    }
    //locate submit buttom
    @FindBy(xpath = "//input[@id=\"sbBt\"]")
    @CacheLookup
    WebElement submitButton;

    public void setSubmitButton() {

        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable((submitButton))).click();
        //wait until next page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"sign-in-h2\"]")));
    }


    //locate the error message
    @FindBy(xpath = "//span[@class=\"help-block errorMsg\"]")
    @CacheLookup
    WebElement alert;

    //find the validation error
    public boolean checkError(){

        return alert.isDisplayed();
    }



    //validate if the error message meets requirements
    public boolean validateError(String error) {
        return alert.getText().equals(error);
    }

    public String actError() {
        return alert.getText();
    }



    }











