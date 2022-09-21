package com.testCases;

import com.base.BaseClass;
import com.pageObjects.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_056 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter Characters in code textbox.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click onSign up button on right side.
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field(Country code other than canada).
//5.Click on JOIN NOW button.
//6.Enter 1234 for ""Email verification"" and click on ""verify""
// 7. Select the locations and click on Next
// 8. In the next screen enter the code to verify your mobile - characters only"

//"The following will happen for the test case to be considered successful:
//AC01: It should display message""Only numbers are allowed."".




    @Test(priority = 59)
    public void JMB_CASignUp_056() throws IOException, NoSuchElementException, InterruptedException {


        logger.info("Started Candidate-Verify Your Mobile- code textbox- Characters");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);
        CA_VerifyEmailPage verifyEmailPage = new CA_VerifyEmailPage(driver);
        CA_infoPages ca_infoPages = new CA_infoPages(driver);
        CA_JobLocationsPage ca_jobLocationsPage = new CA_JobLocationsPage(driver);
        CA_VerifyMobile ca_verifyMobile = new CA_VerifyMobile(driver);

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
        logger.info("passing phone, Canada country code by default");
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

        logger.info("choose certain location");
        ca_jobLocationsPage.chooseCertain();

        logger.info("click next to get redirected to next page");
        ca_jobLocationsPage.nextClick();


        logger.info("pass chars instead of numbers");
        ca_verifyMobile.passCharsMobile();

        logger.info("submit form");
        ca_verifyMobile.hitSubmit();


        logger.info("validate am error message");
        softassert.assertTrue(ca_verifyMobile.errorText().equals("Only numbers are allowed."),
                "Test failed, message is : " + ca_verifyMobile.errorText());

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_056");
    }
}
