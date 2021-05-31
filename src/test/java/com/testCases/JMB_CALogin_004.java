package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class JMB_CALogin_004 extends BaseClass {
	
	@Test(priority=1)
	public void InvalidpwdLogintest() throws IOException
	{
		//Read UserName and password from excel
		String UserName2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 4, 0);       
        String Password2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 4, 1);      
		//Started the login test
		logger.info("Started Logintest");
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		//Clicking on Login button
		lp.clkbtnLogin();
		logger.info("Clicked on Login");
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		
		loginpg.settxtemail(UserName2);		//Pass username read from excel file
		loginpg.settxtpassword(Password2);	//Pass password read from excel file
		logger.info("Entered UserName and Password");
		loginpg.clkbtnSubmit();
		//Click on submit button
		logger.info("Clicked on Submit button");
		//Validate whether InValidlogin is not successful
		SoftAssert softassert = new SoftAssert();			
		if(loginpg.InvalidCreds().equals("Invalid credentials."))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! InvalidpwdLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! InvalidpwdLogintest failed!");
			captureScreen(driver,"InvalidpwdLogintest");
		}
		//Validate if it display login page.
				if(driver.getTitle().equals("Login"))
				{
					softassert.assertTrue(true);
					logger.info("Test Passed! InvalidpwdLogintest Successful!");
				}
				else
				{
					softassert.assertTrue(false);
					logger.error("Test Failed! InvalidpwdLogintest failed!");
					captureScreen(driver,"InvalidpwdLogintest");
				}
		softassert.assertAll();
		logger.info("Completed InvalidpwdLogintest");
		
	}
	
	

}
