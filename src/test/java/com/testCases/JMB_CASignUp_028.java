package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

//"This test case is testing whether a candidate can enter password with
// at least than 6 characters/, contains at least one lowercase letter/ and/or,
// one uppercase letter and/or, one number and/or,  one special character (#, @, -, _, ! and ?)
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter password with at least 6 characters/,
// contains at least one lowercase letter and/or, one uppercase letter and/or,
// one number and/or,  one special character (#, @, -, _, ! and ?)."

//"The following will happen for the test case to be considered successful:
//AC01: It should not display any error message."

public class JMB_CASignUp_028 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

    @Test(priority = 30)
    public void candidateStrongPasswordNegative() throws IOException, NoSuchElementException {

        logger.info("Started Candidate  -Password- at least 6 characters, contains at least one lowercase letter " +
                "and/or, one uppercase letter and/or, one number and/or,  one special character (#, @, -, _, ! and ?) (Negative)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing 6 char password");
        signUpPage.enterStrongPass2();


        logger.info("validate if there's an error message");
        signUpPage.findError("JMB_CASignUp_028");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_028");


    }
}
