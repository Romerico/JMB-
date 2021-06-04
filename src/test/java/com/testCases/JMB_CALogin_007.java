package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.SignUpPage;


public class JMB_CALogin_007 extends BaseClass {
	
	@Test(priority=1)
	public void SignUpLogintest() throws IOException
	{
		//Started the login test
		logger.info("Started Logintest");
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		//Clicking on Login button
		lp.clkbtnLogin();
		logger.info("Clicked on Login");
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		//Click on Signup link
		loginpg.clickOnSignUpLink();	
		loginpg.clickOnCandidateSignUpLink();
		//create an object for Signup page
	    SignUpPage SignPg=new SignUpPage(driver);
	    //Assert if navigated to Signup page
	    SoftAssert softassert = new SoftAssert();
		if(driver.getTitle().equals("Signup"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUpLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUpLogintest failed!");
			captureScreen(driver,"SignUpLogintest");
		}
	    //Assert if Signup is displayed   
		if(SignPg.isSignupDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUpLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUpLogintest failed!");
			captureScreen(driver,"SignUpLogintest");
		}
		//Assert if Image is displayed
		
		if(SignPg.isImageDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUpLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUpLogintest failed!");
			captureScreen(driver,"SignUpLogintest");
		}
		//Assert if Form is Displayed
		
		if(	SignPg.isFormDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! SignUpLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! SignUpLogintest failed!");
			captureScreen(driver,"SignUpLogintest");
		}		
		
		
		softassert.assertAll();
		logger.info("Completed SignUpLogintest");
		
		
		
	}
	

		
	
	

}
