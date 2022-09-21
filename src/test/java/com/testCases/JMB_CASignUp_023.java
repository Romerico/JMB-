package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_023 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter less than 10 digits/more than 10 digits phone number.
//Scenario 1:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter less than 10 digits phone number in phone number.
//
//Scenario 2:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter more than 10 digits phone number in phone number."

//"The following will happen for the test case to be considered successful:
//Scenario 1:
//AC01:  It should  display message""Please enter a valid 10 digit mobile number"".
//
//Scenario 2:
//AC01:  It should  display message""Please enter a valid 10 digit mobile number""."

    @Test(priority = 25)
    public void candidatePhoneNumber10DigitsPositive() throws IOException, NoSuchElementException {

        logger.info("Started Candidate -Phone Number- (Negative)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing less than 10 digits phone number");
        signUpPage.enterPhoneLessThan10();


        logger.info("validate an error message");
        signUpPage.validateErrorMessage("Please enter a valid 10 digit mobile number","JMB_CASignUp_023");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_023");


    }

}
