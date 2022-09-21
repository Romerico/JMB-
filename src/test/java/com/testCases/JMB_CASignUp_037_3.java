package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import com.pageObjects.CA_VerifyEmailPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_037_3 extends BaseClass {
    SoftAssert softassert = new SoftAssert();


//"This test case is testing whether a candidate can see verify your email page.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field(Country code other than canada).
//5.Click on JOIN NOW button"

//"The following will happen for the test case to be considered successful:
//AC01: It should display  Verify Your Email in bold.
//AC02: It should displat text- We have sent a “4 digit code” to Email
//AC03: It should display landing page image on left hand side.
//AC04: It should display Verify Your Email page form details on right hand side.
//AC05: initially It should display textbox empty."


    @Test(priority = 35)
    public void verifyYourEmailPage() throws IOException, NoSuchElementException {


        logger.info("Started - Candidate - verify your email page ");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);
        CA_VerifyEmailPage verifyEmailPage = new CA_VerifyEmailPage(driver);

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

        logger.info("Validate if landing page image is on left hand side");
        softassert.assertTrue(verifyEmailPage.getImagePosition(), "landing page image is NOT on left hand side");
        if (verifyEmailPage.getImagePosition()) {
            logger.info("Landing page image is on left hand side");
        } else {
            captureScreen(driver, "JMB_CASignUp_037_3");
        }

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_037_3");
    }
}
