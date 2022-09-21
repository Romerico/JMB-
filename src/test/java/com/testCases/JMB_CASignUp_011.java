package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_011 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//This test case is testing whether a candidate can enter Last Name no longer than 50 characters.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on "Looking for Work" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Enter Last Name no  longer than 50 characters in last Name.

//"The following will happen for the test case to be considered successful:
//AC01: It should not display error message."


    @Test(priority = 11)
    public void candidateLastNameNoLongerThan50CharTest() throws IOException {
        logger.info("Started Candidate -Last Name- No longer than 50 characters (Positive)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        signUpPage.noLongerThan50CharactersLastName();
        logger.info("Activating textbox and tab out leaving it blank to call the error message");

        logger.info("validate if there's any error");
        signUpPage.findError("JMB_CASignUp_011");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_011");
    }
}
