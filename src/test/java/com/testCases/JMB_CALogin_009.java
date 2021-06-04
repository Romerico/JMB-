package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;


public class JMB_CALogin_009 extends BaseClass {
	
	@Test(priority=1)
	public void CompanyLoginTest() throws IOException
	{
		logger.info("Started Logintest");
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		SoftAssert softassert = new SoftAssert();
		//Assert if Jombone page is displayed
		if(driver.getTitle().equals("Jombone"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyLoginTest Successful!");
			
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyLoginTest failed!");
			captureScreen(driver,"CompanyLoginTest");
		}
		//Clicking on Login button
		lp.clkbtnLogin();
		logger.info("Clicked on Login");
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
			
		//Validate whether CompanyloginPage has primary content in login page
			
		
		if(driver.getTitle().equals("Login"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyLoginTest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyLoginTest failed!");
			captureScreen(driver,"CompanyLoginTest");
		}

		if(loginpg.isEmailTextBoxDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyLoginTest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyLoginTest failed!");
			captureScreen(driver,"CompanyLoginTest");
		}

		if(loginpg.isPasswordTextBoxDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyLoginTest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyLoginTest failed!");
			captureScreen(driver,"CompanyLoginTest");
		}

		if(loginpg.isSubmitButtonDisplayed().equals(true))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyLoginTest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyLoginTest failed!");
			captureScreen(driver,"CompanyLoginTest");
		}
		softassert.assertAll();
		logger.info("Completed CompanyLoginTest");
		
	}
	
	

}
