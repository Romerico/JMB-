package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JMB_CASignUp_015 extends BaseClass {
    SoftAssert softassert = new SoftAssert();
//"This test case is testing whether a candidate can enter regular expression in email.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. Enter regular expression in email."

//"The following will happen for the test case to be considered successful:
//AC01: It should not  display error message."

    @Test(priority = 16)
    public void candidateEmailRegex() {

        logger.info("Started Candidate -Email- regular expression (Positive)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing regex email");
        signUpPage.passRegexMail();

        logger.info("Validating if there's any error message");
        signUpPage.findError("JMB_CASignUp_015");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_015");
    }
}
