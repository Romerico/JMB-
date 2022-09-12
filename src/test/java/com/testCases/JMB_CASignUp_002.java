package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.NoSuchElementException;

public class JMB_CASignUp_002 extends BaseClass {

    //This test case is testing whether a candidate can enter characters with space in First Name.
    //1: Navigate to jombone page
    //2: On Landing Welcome page ,Click on "Looking for Work" and thenClick on Sign up
    //3. On Sign Up page click on Candidate link.
    //4. Enter characters with space in First Name.
//    ( It should not display any error message)

    @Test(expectedExceptions = { NoSuchElementException.class })
    public void spaceInFirstNameTest() throws IOException, NoSuchElementException {

            logger.info("Started  Candidate -First Name- characters and space (Positive) Test");

            SignUpPage signUpPage = new SignUpPage(driver);
            CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

            ca_landingPage.clickLookingForWork();
            logger.info("Clicked on Looking for Work");

            ca_landingPage.clickCandidateSignUp();
            logger.info("Clicked on Sign up");


            logger.info("Passing characters with space in First Name");
            signUpPage.enterFirstNameWithSpaces();


            logger.info("Validating if there's any error message");
//        signUpPage.findError();

            SoftAssert softassert = new SoftAssert();
            boolean err = signUpPage.findErrorB();
            softassert.assertFalse(err);
            if (err) {
                logger.error("Test Failed!");}
            else {

                logger.info("Test Passed!");
            }


            softassert.assertAll();
            logger.info("Completed spaceInFirstNameTest");


        }
    }



