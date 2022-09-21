package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_022 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter 10 digits phone number.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter 10 digits phone number in phone number."

//"The following will happen for the test case to be considered successful:
//AC01:  It should not display error message."

    @Test(priority = 24)
    public void candidatePhoneNumber10DigitsPositive() throws IOException, NoSuchElementException {

        logger.info("Started Candidate -Phone number- contain 10 digits (Positive)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing valid phone number");
        signUpPage.enterValidPhone();


        logger.info("validate if there's an error message");
        signUpPage.findError("JMB_CASignUp_022");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_022");


    }
}
