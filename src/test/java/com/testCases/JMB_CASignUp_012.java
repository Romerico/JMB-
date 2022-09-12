package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_012 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter Last Name longer than 50 characters.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Enter Last Name  longer than 50 characters in last Name."

//"The following will happen for the test case to be considered successful:
//AC01: User should not be able to enter more than 50 characters"

    @Test(priority = 12)
    public void candidateLastNameLongerThan50CharTest() throws IOException {
        logger.info("Started Candidate -Last Name- longer than 50 characters (Negative)");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing 50 acceptable symbols to textbox + validating if max character meets requirement");
        signUpPage.noLongerThan50CharactersLastNameNegative();

        captureScreen(driver, "candidateLastNameLongerThan50CharTest");
        softassert.assertAll();
        logger.info("Completed candidateLastNameLongerThan50CharTest");
    }
}
