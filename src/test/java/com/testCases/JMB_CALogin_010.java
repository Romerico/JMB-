package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;


public class JMB_CALogin_010 extends BaseClass {
	
	@Test(priority=1)
	public void CompanyValidLogintest() throws IOException
	{
		//Read username and password from excel
		String UserName2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 7, 0);       
        String Password2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 7, 1);      
		//Started the login test
		logger.info("Started Logintest");		
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		SoftAssert softassert = new SoftAssert();
		//Assert if Jombone page is displayed
		if(driver.getTitle().equals("Jombone"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyValidLogintest Successful!");
			
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyValidLogintest failed!");
			captureScreen(driver,"CompanyValidLogintest");
		}
		
		//Click on Login button
		lp.clkbtnLogin();	
		
		logger.info("Clicked on Login");
		
		
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		//Validate if navigated to Login page
				if(driver.getTitle().equals("Login"))
				{
					softassert.assertTrue(true);
					logger.info("Test Passed! CompanyValidLogintest Successful!");
				}
				else
				{
					softassert.assertTrue(false);
					logger.error("Test Failed! CompanyValidLogintest failed!");
					captureScreen(driver,"ForgotPasswordtest");
				}


		loginpg.settxtemail(UserName2);		//Pass username1 read from excel file
		loginpg.settxtpassword(Password2);	//pass password read from excel file
		logger.info("Entered UserName and Password");
		loginpg.clkbtnSubmit();//Click on Submit button
		logger.info("Clicked Submit button");		
		//Validate whether valid login is successful	
		
		if(driver.getTitle().equals("Dashboard"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! CompanyValidLogintest Successful!");
			
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! CompanyValidLogintest failed!");
			captureScreen(driver,"CompanyValidLogintest");
		}
		softassert.assertAll();
		logger.info("Completed CompanyValidLogintest");
		
	}
	
	

}
