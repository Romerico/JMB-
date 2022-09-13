package com.testCases;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.SignUpPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class JMB_CASignUp_004 extends BaseClass {

    SoftAssert softassert = new SoftAssert();

//    Candidate -First Name  -  blank (Negative)
//    "This test case is testing whether a candidate can leave  First Name blank.
//1: Navigate to jombone page
//2: On Landing Welcome page ,Click on ""Looking for Work"" and thenClick on Sign up
//3. On Sign Up page click on Candidate link.
//4. Leave First Name blank."

//    The following will happen for the test case to be considered successful:
//AC01: It should display message"Please enter first name".

    @Test(priority = 4)
    public void candidateFirstNameBlankTest() throws IOException {
        logger.info("Started Candidate -First Name- blank (Negative) Test");

        SignUpPage signUpPage = new SignUpPage(driver);
        CA_LandingPage ca_landingPage = new CA_LandingPage(driver);

        ca_landingPage.clickLookingForWork();
        logger.info("Clicked on Looking for Work");

        ca_landingPage.clickCandidateSignUp();
        logger.info("Clicked on Sign up");


        logger.info("Clicked the textbox and left it");
        signUpPage.activateFirstNameTextbox();


        logger.info("Validate if the empty name error message meets requirements");
        signUpPage.validateErrorMessage("Please enter first name", "candidateFirstNameBlankTest");


            captureScreen(driver, "candidateFirstNameBlankTest");
            softassert.assertAll();
            logger.info("Completed candidateFirstNameBlankTest");




        }
    }

