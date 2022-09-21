package com.pageObjects;

import com.base.BaseClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Range;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CA_JobLocationsPage extends BaseClass {


    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public CA_JobLocationsPage(WebDriver driver) {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    //locate title
    @FindBy(xpath = "//h2[contains(text(),'job')]")
    @CacheLookup
    WebElement lookingForJobTitle;

    public boolean getFontValue() throws IOException {

        Range<Integer> myRange = Range.between(700, 900);
        String i = String.valueOf(myRange);
        String fontWeight = lookingForJobTitle.getCssValue("font-weight");

        return fontWeight.equals("bold") || fontWeight.equals(i);
    }

    public String actTitle(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }
    //locate text
    @FindBy(xpath = "//p[@class=\"sign-in-p\"]")
    @CacheLookup
    WebElement locationsText;

    public boolean locationsTextVisibility(){
        return locationsText.isDisplayed();
    }

    //locate left image
    @FindBy(xpath = "//div[@class=\"login_left_section clearfix\"]")
    @CacheLookup
    WebElement jobImage;

    public boolean getImagePosition() {
        int windowWidth = driver.manage().window().getSize().getWidth();
        int xPos = jobImage.getLocation().getX();
        int eleWidth = jobImage.getSize().getWidth();

        return ((xPos + eleWidth) <= windowWidth / 2);

    }
    //locate textbox with autosuggestions
    @FindBy(xpath = "//label[@class=\"control-label\"]")
    @CacheLookup
    WebElement locationTextBox;
    //locate the textbox selenium can interract with
    @FindBy(xpath = "//input[@id=\"autocomplete\"]")
    @CacheLookup
    WebElement locationTextboxInteractable;
    //locate list of autosuggestions
    @FindBy(css = ".pac-container")
    @CacheLookup
    List<WebElement> listOfLocations;

    //locate success message
    @FindBy(xpath = "//div[@class=\"toast toast-success\"]/div[@class=\"toast-message\"]")
    @CacheLookup
    WebElement toastMessage;
    //locate error message
    @FindBy(xpath = "//div[@class=\"toast toast-error\"]/div[@class=\"toast-message\"]")
    @CacheLookup
    WebElement toastError;

    public String popupMessage(){
        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(toastMessage));

        return toastMessage.getText();
    }

    public String popupError(){

        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(toastError));

          return  toastError.getText();

        }

    public String locationTextBoxText(){
        return locationTextBox.getText();
    }

    public void chooseRandom(){
        String random = RandomStringUtils.randomAlphabetic(1);

        locationTextboxInteractable.sendKeys(random);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfLocations));

        listOfLocations.get(0).click();

        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(locationsDismissButton));

    }

    public void chooseRandom10() {
        try {
            for (int i = 0; i < 10; i++) {
                String random = RandomStringUtils.randomAlphabetic(1);

                FluentWait wait = new FluentWait(driver);

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOf(toastMessage));

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
                wait.until(ExpectedConditions.visibilityOf(locationTextboxInteractable));

                locationTextboxInteractable.sendKeys(random);

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfAllElements(listOfLocations));

                listOfLocations.get(0).click();

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfAllElements(locationsDismissButton));

            }
        } catch (StaleElementReferenceException e) {

        }

    }

    public void chooseMoteThan10() {

        try {
            for (char alphabet = 'a'; 'a' < 'k'; alphabet++ ) {

                String a = String.valueOf(alphabet);

                FluentWait wait = new FluentWait(driver);

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.invisibilityOf(toastMessage));

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
                wait.until(ExpectedConditions.visibilityOf(locationTextboxInteractable));

                locationTextboxInteractable.sendKeys(a);

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfAllElements(listOfLocations));

                listOfLocations.get(0).click();

                wait.withTimeout(Duration.ofSeconds(15));
                wait.pollingEvery(Duration.ofSeconds(3));
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfAllElements(locationsDismissButton));

            }
        } catch (StaleElementReferenceException e) {

        }

    }

    public void chooseCertain() throws InterruptedException {


            FluentWait wait = new FluentWait(driver);

            wait.withTimeout(Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
            wait.until(ExpectedConditions.visibilityOf(locationTextboxInteractable));

            locationTextboxInteractable.sendKeys("n");

            wait.withTimeout(Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfAllElements(listOfLocations));

            listOfLocations.get(0).click();

            wait.withTimeout(Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(toastMessage));
        }




        public void chooseTheSame(){
            try{
            FluentWait wait = new FluentWait(driver);

            wait.withTimeout(Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(toastMessage));

            locationTextboxInteractable.sendKeys("n");

            wait.withTimeout(Duration.ofSeconds(15));
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfAllElements(listOfLocations));

            listOfLocations.get(0).click();

            }
            catch(StaleElementReferenceException e){

            }

        }

    //locate delete location button
    @FindBy(xpath = "//button[@class=\"close deleteDesk\"]")
    @CacheLookup
    WebElement locationsDismissButton;



    public void clickDismiss(){

        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(toastMessage));

        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(locationsDismissButton));

        locationsDismissButton.click();

    }
    //locate location row
    @FindBy(xpath = "//div[@class=\"loc_div_desk\"]/div[contains(@class, 'alert alert-light')]")
    @CacheLookup
    WebElement certainLoc;
    public boolean certainLocVisibility(){

        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(certainLoc));

        return certainLoc.isDisplayed();
    }

    @FindBy(xpath = "//a[@class=\"finishBtnDesk\"]")
    @CacheLookup
    WebElement nextButton;

    public void nextClick(){
        nextButton.click();
    }

    public boolean getListLocation(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(locationsDismissButton,nextButton ));

        int windowHeight = driver.manage().window().getSize().getHeight();
        int listPositions = locationsDismissButton.getLocation().getY();
        int nextButtonposition = nextButton.getLocation().getY();


        return listPositions > nextButtonposition;

    }






}

