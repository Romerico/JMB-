package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_018 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can select country code as a Canada.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Select country code as a Canada."

//"The following will happen for the test case to be considered successful:
//AC01:  It should follow OTP verification step for sign up.


    @Test(priority = 19)
    public void countryCodeCanada() throws IOException, NoSuchElementException {

        logger.info("Started Candidate - Country Code - Canada ");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

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


        logger.info("validate a page user was redirected to");
        softassert.assertFalse(driver.getTitle().contains("Verify"), "Test Failed. Page is : " + driver.getTitle());
        if (driver.getTitle().contains("Verify")) {
            captureScreen(driver, "JMB_CASignUp_018");
        } else {
            logger.info("Test passed! Page is : " + driver.getTitle());
        }

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_018");
    }
}
