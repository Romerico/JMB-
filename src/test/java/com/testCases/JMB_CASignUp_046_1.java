package com.testCases;

import com.base.BaseClass;
import com.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_046_1 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can see Where are you looking for a job? page.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter all valid data in each field.
//5.Click on JOIN NOW button.
//6.Enter valid code and click on verify button.

//AC01: It should display  Where are you looking for a job? in bold.


    @Test(priority = 47)
    public void JMB_CASignUp_046_1() throws IOException, NoSuchElementException, InterruptedException {


        logger.info("Started Candidate- Where are you looking for a job? page ");

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

        logger.info("passing valid code");
        verifyEmailPage.passValidNumbersEmail();

        logger.info("submit form");
        verifyEmailPage.submitForm();

        logger.info("Validate if it displayed Where are you looking for a job page");

        softassert.assertTrue(ca_jobLocationsPage.pageTitle("Where are you looking for a job?"));


        softassert.assertTrue(ca_jobLocationsPage.getFontValue(),
                "Title font is not bold and is : "
                        + driver.findElement(By.xpath("//h2[contains(text(),'job')]")).getCssValue("font-weight")
                        + "while bold is between 700 and 900");



        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_046_1");

        }
}
