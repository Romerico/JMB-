package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_006 extends BaseClass {

    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter First Name longer than 50 characters.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Enter First Name  longer than 50 characters in First Name."

//    "The following will happen for the test case to be considered successful:
//    AC01: User should not be able to enter more than 50 characters"

    @Test(priority = 6)
    public void noLongerThan50CharactersNegativeTest() throws IOException {
        logger.info("Started Candidate -First Name- No longer than 50 characters (Negative)");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("Passing 51 acceptable symbols to textbox");
        signUpPage.noLongerThan50CharactersNegative();


        captureScreen(driver, "noLongerThan50CharactersNegativeTest");
        softassert.assertAll();
        logger.info("Completed noLongerThan50CharactersNegativeTest");
    }
    }



