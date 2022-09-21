package com.pageObjects;

import com.base.BaseClass;
import com.mifmif.common.regex.Generex;
import org.apache.commons.lang3.Range;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class CA_VerifyEmailPage extends BaseClass {

    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public CA_VerifyEmailPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }

    //locate submit button
    @FindBy(xpath = "//input[@value='Verify']")
    @CacheLookup
    WebElement verifyButton;

    public void submitForm() {
        verifyButton.click();
    }

    //locate page title
    @FindBy(css = "head > title")
    @CacheLookup
    WebElement title;

    public boolean getFontValue() throws IOException {
        Range<Integer> myRange = Range.between(700, 900);
        String i = String.valueOf(myRange);
        String fontWeight = title.getCssValue("font-weight");

        return fontWeight.equals("bold") || fontWeight.equals(i);
    }
    //locate subtitle
    @FindBy(xpath = "//p[@class=\"sign-in-p\"]")
    @CacheLookup
    WebElement FourDigitCode;

    public boolean fourDigitCode() {
        return FourDigitCode.isDisplayed();
    }

    //locate left image
    @FindBy(xpath = "//img[@src='/resources/assets/images/login-bg.jpg']")
    @CacheLookup
    WebElement image;

    public boolean getImagePosition() {
        int windowWidth = driver.manage().window().getSize().getWidth();
        int xPos = image.getLocation().getX();
        int eleWidth = image.getSize().getWidth();

        return ((xPos + eleWidth) <= windowWidth / 2);

    }
    //locate main content to the right of an image
    @FindBy(xpath = "//div[@class=\"login_right_section clearfix\"]")
    @CacheLookup
    WebElement emailForm;

    public boolean getEmailFormPosition() {

        int windowWidth = driver.manage().window().getSize().getWidth();
        int xPos = emailForm.getLocation().getX();
        int eleWidth = emailForm.getSize().getWidth();

        return ((xPos + eleWidth) >= windowWidth / 2);
    }
    //locate OTP textboxes
    @FindBy(xpath = "//input[@autocomplete=\"off\"]")
    @CacheLookup
    java.util.List<WebElement> textBoxes;

    public void textBoxesEmpty() throws IOException {

        java.util.List<WebElement> text = textBoxes;
        java.util.List<String> values = new ArrayList<>();


        for (int i = 0; i < text.size(); i++) {
            values.add(text.get(i).getAttribute("value"));
            softassert.assertTrue(values.get(i).isEmpty());
            if (values.get(i).isEmpty()) {
                logger.info("Checkbox " + (i + 1) + " of " + text.size() + " is initially empty");
            } else {
                captureScreen(driver, "JMB_CASignUp_037_1 textboxes");
                softassert.fail("Checkbox" + (i + 1) + " of " + values.size() + "is not initially empty");
            }
        }
    }

    public void passNumbersEmail() {
        java.util.List<WebElement> text = textBoxes;


        Generex gen = new Generex("(0-9)");
        String randomNumber = gen.random(1);

        for (WebElement textbox : text) {
            textbox.sendKeys(randomNumber);

        }
    }

    public void passCharsEmail() {
        java.util.List<WebElement> text = textBoxes;

        Generex gen = new Generex("(a-z)");
        String randomNumber = gen.random(1);

        for (WebElement textbox : text) {
            textbox.sendKeys(randomNumber);

        }
    }

    public void passValidNumbersEmail() {
        java.util.List<WebElement> text = textBoxes;
        int i;
        int j = 1;

        for (i = 0; i < text.size(); i++) {

            String code = String.valueOf(j++);
            text.get(i).sendKeys(code);

        }
    }

    public void passBlankEmailCode() {
        java.util.List<WebElement> text = textBoxes;
        int i;

        for (i = 0; i < text.size(); i++) {


            text.get(i).sendKeys(Keys.TAB);

        }
    }

    public void passLessThan4EmailCode() {
        java.util.List<WebElement> text = textBoxes;
        int i;

        for (i = 1; i < text.size(); i++) {


            text.get(i).sendKeys("1");

        }
    }
    //locate email popup
    @FindBy(xpath = "//div[@class=\"modal-content overflow-hidden\"]//h4[@class=\"jb-popup-h4-title\" and contains(text(),'Update Email')]")
    @CacheLookup
    WebElement emailPopup;

    public boolean emailPopupVisibility(){

        return emailPopup.isDisplayed();
    }
    //locate edit email link
    @FindBy(xpath = "//a[@class=\"editEmailCss\"]")
    @CacheLookup
    WebElement editEmailLink;

    public void clickEditEmail(){
        editEmailLink.click();
    }
    //locate resend code link
    @FindBy(xpath = "//a[@class=\"resendVerification\"]")
    @CacheLookup
    WebElement resendCodeLink;

    public void clickResendCodeLink(){
        resendCodeLink.click();
    }
    //locate resend code popup
    @FindBy(xpath = "//h4[@class=\"jb-popup-h4-title\" and contains (text(),'Code')]")
    @CacheLookup
    WebElement resendCodePopup;

    public boolean resendCodePopupVisibility(){

        return resendCodePopup.isDisplayed();
    }

    //locate error message
    @FindBy(xpath = "//span[@class=\"errorMsg errMszClass\"]")
    @CacheLookup
    WebElement alertEmail;


    public void findErrorEmail(String tname) {

        try {
            String error = alertEmail.getText();

            softassert.assertTrue(error.isEmpty());

            if (!error.isEmpty()) {
                logger.info("error is displayed" + alertEmail.getText());
                captureScreen(driver, tname);
            } else {
                logger.info("Test Passed!");
            }


        } catch (NoSuchElementException | IOException e) {
            logger.info("Test Passed!");

        }
    }


    public void validateErrorMessageMail(String expAlert, String tname) throws NoSuchElementException {
        try {
            String actAlert = alertEmail.getText();
            softassert.assertTrue(actAlert.equals(expAlert));
            if (actAlert.equals(expAlert)) {
                logger.info("Test passed, message is : " + actAlert);
            } else {
                captureScreen(driver, tname);
                Assert.fail("Test Failed! Message is : " + actAlert);
            }
        } catch (NoSuchElementException | IOException e) {

            Assert.fail("User did not get validation error message");
        }
    }
    //locate error popup
    @FindBy(xpath = "//div[@class='toast-message']")
    @CacheLookup
    WebElement alertError;
    public void validateAlertMessageMail(String expAlert, String tname) throws IOException, NoSuchElementException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(alertError));

        String actAlert = alertError.getText();

        softassert.assertTrue(actAlert.equals(expAlert));
        try {
            if (actAlert.equals(expAlert)) {
                logger.info("Test passed, message is : " + actAlert);
            } else {
                captureScreen(driver, tname);
                Assert.fail("Test Failed! Message is : " + actAlert);
            }
        }
            catch(NoSuchElementException | IOException e){


                Assert.fail("User did not get alert error message");
            }
        }
    }













