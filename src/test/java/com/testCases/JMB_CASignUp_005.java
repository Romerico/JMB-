package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class JMB_CASignUp_005 extends BaseClass {
    SoftAssert softassert = new SoftAssert();


//    This test case is testing whether a candidate can enter First Name no longer than 50 characters.
//1: Navigate to jombone page
//2:  On Landing Welcome page ,Click on "Looking for Work" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.Enter First Name no  longer than 50 characters in First Name.

//The following will happen for the test case to be considered successful:
//AC01: It should not display error message.

    @Test(priority = 5)
    public void noLongerThan50CharactersTest() throws IOException, NoSuchElementException {
        logger.info("Started Candidate -First Name- No longer than 50 characters (Postive)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        signUpPage.noLongerThan50Characters();
        logger.info("Passing 50 acceptable symbols to textbox");

        logger.info("validating if there's any error message");

        signUpPage.findError("JMB_CASignUp_005");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_005");
    }


}