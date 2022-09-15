package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_035 extends BaseClass {
    SoftAssert softassert = new SoftAssert();
//"This test case is testing whether a candidate can click on Privacy Policy link.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and then Click on Sign up
//3. On Sign Up page click on Candidate link.
//4.Click on Privacy Policy link."

//"The following will happen for the test case to be considered successful:
//AC01: It should display PRIVACY POLICY page."
@Test(priority = 28)
public void candidateClickPrivacyPolicy() throws IOException, NoSuchElementException {

    logger.info("Started Candidate click on Privacy Policy link");

    SignUpPage signUpPage = new SignUpPage(driver);
    CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

    ca_landingPage.clickLookingForWork();
    logger.info("Clicked on Looking for Work");

    ca_landingPage.clickCandidateSignUp();
    logger.info("Clicked on Sign up");


    logger.info("Click on Privacy Policy link");
    signUpPage.clickPolicyLink();

    signUpPage.switchToPopUpTab();

    logger.info("Validate if it displayed Privacy Policy by the element of an actual title of a page user was redirected to");

    if(signUpPage.pageTitle("//div[@id='privacy']/h2", "PRIVACY POLICY")){
        logger.info("Test passed!");
    }
    else{
        logger.info("Test Failed! User is redirected to other page! Title is: " + signUpPage.actTitle("//div[@id='privacy']/h2"));
        captureScreen(driver,"candidateClickPrivacyPolicy");
    }


    softassert.assertAll();
    logger.info("Completed candidateClickPrivacyPolicy");
}
}
