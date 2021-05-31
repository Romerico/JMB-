package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;


public class JMB_CALogin_008 extends BaseClass {
	
	@Test(priority=1)
	public void ForgotPasswordtest() throws IOException
	{
		logger.info("Started Logintest");
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		//Clicking on Login button
		lp.clkbtnLogin();
		logger.info("Clicked on Login");
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		//click on Forgotpassword link
		loginpg.clickOnForgotPasswordLink();	
		//Validate whether navigated to Forgotpassword page 
		SoftAssert softassert = new SoftAssert();	
		
		if(driver.getTitle().equals("Forgot Password"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! ForgotPasswordtest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! ForgotPasswordtest failed!");
			captureScreen(driver,"ForgotPasswordtest");
		}
		softassert.assertAll();
		logger.info("Completed ForgotPasswordtest");
		
	}
	
	

}
