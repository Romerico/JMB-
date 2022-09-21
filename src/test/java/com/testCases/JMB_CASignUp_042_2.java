package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import com.pageObjects.CA_VerifyEmailPage;
import com.pageObjects.CA_infoPages;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_042_2 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

// "This test case is testing whether a candidate can leave code blank/less than 4 digits .
//Scenario2:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on "Looking for Work" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field(Country code other than canada).
//5.Click on JOIN NOW button.
//6.enter code Less than 4 digits.
//7.Click on verify button.

//Scenario2:
//AC01: It should display message"Please enter a valid verification code.".

    @Test(priority = 43)
    public void JMB_CASignUp_042_2() throws IOException, NoSuchElementException, InterruptedException {


        logger.info("Started Candidate- verify your email - Code - Less than 4 digits(error page element)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);
        CA_VerifyEmailPage verifyEmailPage = new CA_VerifyEmailPage(driver);
        CA_infoPages ca_infoPages = new CA_infoPages(driver);

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

        logger.info("passing less than 4 digits");
        verifyEmailPage.passLessThan4EmailCode();

        logger.info("submit form");
        verifyEmailPage.submitForm();

        logger.info("verifying if error message is present: 'Please enter a valid verification code.'");
        softassert.assertTrue(verifyEmailPage.validateError("Please enter a valid verification code."),
                "Test Failed! Message is: " + verifyEmailPage.actError());



        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_042_2");
    }
}

