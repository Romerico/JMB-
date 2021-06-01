package com.base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig  readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public String baseURL=readconfig.getApplicationURL(); 
	public String username1=readconfig.getUsername1();
	public String password=readconfig.getPassword(); 
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setup()
	{		
		// Initialization // Logger initiated within the setup method
		logger=Logger.getLogger("Jombone");// Project Name 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		driver.get(baseURL);
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
	
}