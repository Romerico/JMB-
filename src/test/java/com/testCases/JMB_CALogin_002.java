package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.base.BaseClass;
import com.pageObjects.CA_LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;


public class JMB_CALogin_002 extends BaseClass {
	
	@Test(priority=1)
	public void BlankEmailIdLogintest() throws IOException
	{
		//Read data from excel
		String UserName2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 2, 0);       
        String Password2 =XLUtils.getCellData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\Jombone_LoginData.xlsx", "sheet1", 2, 1);      
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
		loginpg.settxtpassword(Password2);	// pass password read from excel file
		logger.info("Entered UserName and Password");
		//Click on submit button
		loginpg.clkbtnSubmit();
		logger.info("Clicked on Submit button");
		
		
		//Validate whether Invalid login is not successful
		SoftAssert softassert = new SoftAssert();	
		
		if(loginpg.blankEmail().equals("Please enter valid email."))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! BlankEmailIdLogintest Successful!");
			
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! BlankEmailIdLogintest failed!");
			captureScreen(driver,"BlankEmailIdLogintest");
		}
		softassert.assertAll();
		logger.info("Completed BlankEmailIdLogintest");
		
	}
	
	

}
