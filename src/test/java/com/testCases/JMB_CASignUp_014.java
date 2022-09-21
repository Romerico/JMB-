package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_014 extends BaseClass {
    SoftAssert softassert = new SoftAssert();
//"This test case is testing whether a candidate can leave email blank / enter  Irregular expression email.
//Scenario 1:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4. leave email blank.
//
//Scenario 2:
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4. Enter irregular expression in email."
// (Should follow regular expression ^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)

//"The following will happen for the test case to be considered successful:
//Scenario 1:
//AC01: It should display message""Please enter a valid email"".
//Scenario 2:
//AC01: It should display message""Please enter a valid email""."

    @Test(priority = 14)
    public void JMB_CASignUp_014() throws IOException {

        logger.info("Started Candidate - Email (Negative) Blank");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        signUpPage.activateEmailTextbox();
        logger.info("leaving email textbox empty");

        logger.info("validate an error message");
        signUpPage.validateErrorMessage("Please enter a valid email", "JMB_CASignUp_014");

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_014");
    }
}