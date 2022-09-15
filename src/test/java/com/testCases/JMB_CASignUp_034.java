package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class JMB_CASignUp_034 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can click on User Agreement link.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4.Click on User Agreement link."

//"The following will happen for the test case to be considered successful:
//AC01: It should display TERMS AND CONDITIONS page."

    @Test(priority = 28)
    public void candidateClickUserAgreement() throws IOException, NoSuchElementException {

        logger.info("Started Candidate click on User Agreement link");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");


        logger.info("Click on User Agreement link");
        signUpPage.clickConsentLink();

        signUpPage.switchToPopUpTab();

        logger.info("Validate if it displayed Terms and conditions by the element of an actual title of a page user was redirected to");

        if(signUpPage.pageTitle("//div[@id='terms']/h2", "TERMS AND CONDITIONS")){
            logger.info("Test passed!");
        }
        else{
            logger.info("Test Failed! User is redirected to other page! Title is: " + signUpPage.actTitle("//div[@id='terms']/h2"));
            captureScreen(driver,"candidateClickUserAgreement");
        }


        softassert.assertAll();
        logger.info("Completed candidateClickUserAgreement");
    }



}

