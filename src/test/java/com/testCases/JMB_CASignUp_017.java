package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JMB_CASignUp_017 extends BaseClass {
    SoftAssert softassert = new SoftAssert();
//"This test case is testing whether a candidate can enter  email  longer than 255 characters.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4. Enter email longer than 255 characters in email."

//"The following will happen for the test case to be considered successful:
//AC01:  It should display message""Please enter a valid email""."

    @Test(priority = 18)
    public void JMB_CASignUp_017() throws NoSuchElementException {

        logger.info("Started Candidate -Email- longer than 80 characters (Negative)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing email of 255 chars");
        signUpPage.passLongerThan255();

        logger.info("validate an error message: 'Please enter a valid email'");
        softassert.assertTrue(signUpPage.validateError("Please enter a valid email"),
                "Test Failed! Message is: " + signUpPage.actError());

        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_017");
    }
}
