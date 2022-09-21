package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_001 extends BaseClass {

    //This test case is testing whether a candidate can click on Candidate link.
    //1.Navigate to Jombone page.
    //2.On Landing Welcome page ,Click on "Looking for Work".
//    3.On Looking for work section click on Sign Up.

//    The following will happen for the test case to be considered successful:
//    AC01: It should display Sign Up form for candidate.

    @Test(priority=1)
    public void JMB_CASignUp_001() throws IOException
    {
        logger.info("Started Candidate click on candidate link Test");
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        logger.info("Clicked on Looking for Work");
        ca_landingPage.clickLookingForWork();

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");


        logger.info("Validate if user is redirected to signup form");
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(driver.getTitle().equals("Signup"), "Test Failed! User is redirected to other page! Page title is : " + driver.getTitle());
        if(driver.getTitle().equals("Signup"))
        {
            softassert.assertTrue(true);
            logger.info("Test Passed! User is redirected to signup form! Page title is : " + driver.getTitle());
        }
        else
        {

            captureScreen(driver,"JMB_CASignUp_001");
        }
        softassert.assertAll();
        logger.info("Completed JMB_CASignUp_001");

    }



}
