package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import com.pageObjects.CA_VerifyEmailPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_041 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//Scenario1:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on "Looking for Work" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field(Country code other than canada).
//5.Click on JOIN NOW button.
//6.enter code not same as received in email .
//7.Click on verify button.

//"The following will happen for the test case to be considered successful:
//    Scenario1:
//    AC01:It should display message""Please enter a valid verification code."".

    @Test(priority = 41)
    public void verifyYourEmailPageTextBoxWrongCode() throws IOException, NoSuchElementException {


        logger.info("Started Candidate- verify your email - Code - not same as received in email .");

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

        logger.info("passing numbers to text boxes");
        verifyEmailPage.passNumbersEmail();
        logger.info("submit form");
        verifyEmailPage.submitForm();

        logger.info("verifying if popup error message is displayed");
        verifyEmailPage.validateAlertMessageMail("Please enter a valid verification code.", "JMB_CASignUp_041");

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_041");

    }
}