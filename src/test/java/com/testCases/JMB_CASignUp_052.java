package com.testCases;

import com.base.BaseClass;
import com.pageObjects.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_052 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can leave location blank.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on Sign up  button on right side.
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field.
//5.Click on JOIN NOW button.
//6.Enter valid code and click on verify button.
//7.Leave location blank.
//8.Click on Next button."


//"The following will happen for the test case to be considered successful:
//AC01: It should display error message""Please select at least one location."".



    @Test(priority = 56)
    public void locationBlank() throws IOException, NoSuchElementException, InterruptedException {


        logger.info("Started Candidate- Where are you looking for a job? page  - Location - blank");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);
        CA_VerifyEmailPage verifyEmailPage = new CA_VerifyEmailPage(driver);
        CA_infoPages ca_infoPages = new CA_infoPages(driver);
        CA_JobLocationsPage ca_jobLocationsPage = new CA_JobLocationsPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("registering new account by passing random credentials to get to verification stage");
        signUpPage.noLongerThan50Characters();
        logger.info("passing first name");
        signUpPage.noLongerThan50CharactersLastName();
        logger.info("passing last name");
        logger.info("passing email");
        signUpPage.passRegexMail();
        logger.info("passing phone");
        signUpPage.chooseNotCanada();
        signUpPage.enterValidPhone();
        logger.info("passing password");
        signUpPage.enterStrongPass();
        logger.info("click consent label");
        signUpPage.consentLabelClick();
        logger.info("click policy label");
        signUpPage.policylableClick();
        logger.info("submit captcha");
        signUpPage.clickCaptchaLabel();
        logger.info("click join now");
        signUpPage.setSubmitButton();

        logger.info("passing valid '1234' to textboxes");
        verifyEmailPage.passValidNumbersEmail();


        logger.info("submit form");
        verifyEmailPage.submitForm();


        logger.info("choose no locations by no actions");

        logger.info("click next to get redirected to next page");
        ca_jobLocationsPage.nextClick();

        logger.info("validate if user gets an error message");
        softassert.assertTrue(ca_jobLocationsPage.popupError().equals("Please select at least one location."), "Test Failed. The message is  : " + ca_jobLocationsPage.popupError());
        if(ca_jobLocationsPage.popupError().equals("Please select at least one location")){
            logger.info("Test passed!");
        }
        else{
            captureScreen(driver, "JMB_CASignUp_052");
        }


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_052");
    }
}