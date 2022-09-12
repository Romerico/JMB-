package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_010 extends BaseClass {

    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can leave  Last Name blank.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3.On Sign Up page click on Candidate link.
//4. Leave Last Name blank."
// "The following will happen for the test case to be considered successful:
//AC01: It should display message""Please enter Last Name""."


    @Test(priority = 10)
    public void candidateLastNameBlankTest() throws IOException {
        logger.info("Started Candidate - Last Name  - special characters (Negative)");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        signUpPage.activateLastNameTextbox();
        logger.info("Activating textbox and tab out leaving it blank to call the error message");

        logger.info("validate an error");
        signUpPage.validateEmptyLastNameError();


        captureScreen(driver, "candidateLastNameBlankTest");
        softassert.assertAll();
        logger.info("Completed candidateLastNameBlankTest");
    }
}
