package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_002 extends BaseClass {

    //This test case is testing whether a candidate can enter characters with space in First Name.
    //1: Navigate to jombone page
    //2: On Landing Welcome page ,Click on "Looking for Work" and thenClick on Sign up
    //3. On Sign Up page click on Candidate link.
    //4. Enter characters with space in First Name.
//    ( It should not display any error message)
    @FindBy(xpath = "//span[@class=\"help-block errorMsg\"]")
    @CacheLookup
    WebElement alert;
    SoftAssert softassert = new SoftAssert();


    @Test(priority = 2)
    public void JMB_CASignUp_002() throws IOException, NoSuchElementException {

            logger.info("Started  Candidate -First Name- characters and space (Positive) Test");

            CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
            CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

            ca_landingPage.clickLookingForWork();
            logger.info("Clicked on Looking for Work");

            ca_landingPage.clickCandidateSignUp();
            logger.info("Clicked on Sign up");


            logger.info("Passing characters with space in First Name");
            signUpPage.enterFirstNameWithSpaces();


            logger.info("Validating if there's any error message");

            signUpPage.findError("JMB_CASignUp_002");


            softassert.assertAll();
            logger.info("Completed JMB_CASignUp_002");


        }
    }



