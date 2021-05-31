package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class JMB_CALogin_013 extends BaseClass {
	
	@Test(priority=1)
	public void InvalidEmailpwdCompanyLogintest() throws IOException
	{
		//read username and password from excel sheet
		String UserName2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 10, 0);       
        String Password2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 10, 1);      
		//Started the login test
		logger.info("Started Logintest");
		//Create the object for LandingPage
		CA_LandingPage lp = new CA_LandingPage(driver);
		SoftAssert softassert = new SoftAssert();
		//Validate if Jombone landing page is open
		if(driver.getTitle().equals("Jombone"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! InvalidEmailpwdCompanyLogintest Successful!");
			
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! InvalidEmailpwdCompanyLogintest failed!");
			captureScreen(driver,"InvalidEmailpwdCompanyLogintest");
		}
		
		
		//Clicking on Login button
		lp.clkbtnLogin();
		logger.info("Clicked on Login");
		
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		
		//Validate Login page is open
				if(driver.getTitle().equals("Login"))
				{
					softassert.assertTrue(true);
					logger.info("Test Passed! InvalidEmailpwdCompanyLogintest Successful!");
				}
				else
				{
					softassert.assertTrue(false);
					logger.error("Test Failed! InvalidEmailpwdCompanyLogintest failed!");
					captureScreen(driver,"InvalidEmailpwdCompanyLogintest");
				}


		loginpg.settxtemail(UserName2);		//Pass username1 read from excel file
		loginpg.settxtpassword(Password2);	//Pass password read from excel file
		logger.info("Enetered UserName and Passsword");
		loginpg.clkbtnSubmit();
		//Click on submit button
		logger.info("Clicked on Submit");
		//Validate whether InValidlogin is not successful
				
		if(loginpg.InvalidCreds().equals("Invalid credentials."))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! InvalidEmailpwdCompanyLogintest Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! InvalidEmailpwdCompanyLogintest failed!");
			captureScreen(driver,"InvalidEmailpwdCompanyLogintest");
		}
		softassert.assertAll();
		logger.info("Completed InvalidEmailpwdCompanyLogintest");
		
	}
	
	

}
