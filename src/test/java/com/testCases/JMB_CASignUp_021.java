package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.CA_SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_021 extends BaseClass {
    SoftAssert softassert = new SoftAssert();

//"This test case is testing whether a candidate can leave phone number blank.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4.leave phone number blank."

//"The following will happen for the test case to be considered successful:
//AC01:  It should  display message""Please enter your mobile number""."


    @Test(priority = 23)
    public void JMB_CASignUp_021() throws IOException, NoSuchElementException {

        logger.info("Started Candidate -Phone number- blank (Negative)");

        CA_SignUpPage signUpPage = new CA_SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");

        logger.info("leaving phone textbox empty");
        signUpPage.activatePhoneTextbox();


        logger.info("validate if there's an error message");
        signUpPage.validateErrorMessage("Please enter your mobile number", "JMB_CASignUp_021");


        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_021");


    }
}
