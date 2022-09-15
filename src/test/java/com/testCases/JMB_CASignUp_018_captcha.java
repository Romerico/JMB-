package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class JMB_CASignUp_018_captcha extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can select country code as a Canada.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Select country code as a Canada."

//"The following will happen for the test case to be considered successful:
//AC01:  It should follow OTP verification step for sign up.
//AC02:  It should not follow Email verification step for sign up.


    @Test(priority = 19)
    public void countryCodeCanada() throws IOException {

        logger.info("Started Candidate - Country Code - Canada ");

        SignUpPage signUpPage = new SignUpPage(driver);
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
        signUpPage.passRegexMail();
        logger.info("passing email");
        logger.info("passing phone");
        signUpPage.enterValidPhone();
        logger.info("passing password");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signUpPage.enterValidPass();
//        signUpPage.setConsentLabel();
//        signUpPage.setPolicyLabel();
//        signUpPage.setCaptchaLabel();
        signUpPage.setSubmitButton();

        logger.info("validate a page user was redirected to");
        if(driver.getTitle().contains("Verify"))
        {
            softassert.assertTrue(true);
            logger.error("Test Failed! User is redirected to any of verification form!");
            captureScreen(driver,"countryCodeCanada");
        }
       else
        {
            softassert.assertTrue(false);
            logger.info("Test Passed! User is not redirected to any of described verification forms!");

        }


        softassert.assertAll();
        logger.info("Completed countryCodeCanada");

    }
}
