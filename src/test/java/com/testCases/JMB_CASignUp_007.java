package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_007 extends BaseClass {

    SoftAssert softassert = new SoftAssert();


//This test case is testing whether a candidate can enter number in  First Name.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on "Looking for Work" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Enter number in First Name.

//    The following will happen for the test case to be considered successful:
//    AC01: It should display message"Only character and spaces allowed".

    @Test(priority = 7)
    public void candidateFirstNameNumberTest() throws IOException {
        logger.info("Started Candidate -First Name- number (Negative)");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        signUpPage.enterFirstNameWithNumber();
        logger.info("passing a number into a First name textbox");

        logger.info("Validating if error message meets requirements");
        signUpPage.validateErrorMessage("Only character and spaces allowed", "candidateFirstNameNumberTest" );


        captureScreen(driver, "candidateFirstNameNumberTest");
        softassert.assertAll();
        logger.info("Completed candidateFirstNameNumberTest");
    }
}