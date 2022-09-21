package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_026 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can enter password with at least 6 characters, contains at least one lowercase letter, one uppercase letter, one number and one special character (#, @, -, _, ! and ?).
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4. enter password with at least 6 characters, contains at least one lowercase letter, one uppercase letter, one number and one special character (#, @, -, _, ! and ?)."

//"The following will happen for the test case to be considered successful:
//    AC01:  It should not display error message."




    @Test(priority = 29)
    public void candidateStrongPasswordPositive() throws IOException, NoSuchElementException {

        logger.info("Started Candidate -Password- at least 6 characters, contains at least one lowercase letter," +
                "one uppercase letter, one number and one special character (#, @, -, _, ! and ?) (Positive)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("passing 6 char password");
        signUpPage.enterStrongPass();


        logger.info("validate if there's an error message");
        signUpPage.findError("JMB_CASignUp_026");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_026");


    }
}
