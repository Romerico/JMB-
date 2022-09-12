package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JMB_CASignUp_016 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter  email no longer than 255 characters.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4. Enter email no longer than 255 characters in email."

//"The following will happen for the test case to be considered successful:
//AC01: It should not  display error message."


    @Test(priority = 17)
    public void candidateNoLongerThan255() {

        logger.info("Started Candidate -Email- No longer than 255 characters (Positive)");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing email of 255 chars");
        signUpPage.passNolongerThan255();

//        logger.info("validate an error message");
//
//        signUpPage.findError();


        softassert.assertAll();
        logger.info("Completed candidateNoLongerThan255");
    }
}
