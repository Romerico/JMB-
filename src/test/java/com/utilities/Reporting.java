package com.utilities;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static com.base.BaseClass.driver;


public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html"; // Report name and time stamp in html format

		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report

		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report - given by the user
		htmlReporter.config().setReportName("Functional Testing"); // name of the report - given by the user
		htmlReporter.config().setTheme(Theme.DARK); //
	//	htmlReporter.config().setTheme(Theme.STANDARD); 
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		// System info can be any info defined by the User that comes in the report
		// populate the common details
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","busyQA");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,IE");
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public void onTestSuccess (ITestResult result)
	{

		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		
		
		}
	
	public void onTestFailure (ITestResult result) {

		String failedTest = result.getName();
		test=extent.createTest(failedTest); // create new entry in the report

		String screenshotPath=System.getProperty("user.dir")+ "//Screenshots" + failedTest + ".png";

		try {
			captureScreen(driver, failedTest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.error("Test Case: " + failedTest + " FAILED");
		test.log(Status.FAIL, "TEST CASE FAILED TO " + result.getThrowable());


		try {
			test.log(Status.FAIL, "Screenshot").addScreenCaptureFromPath(screenshotPath, failedTest);
		} catch (IOException e) {
			e.printStackTrace();
		}


//		String screenshotPath=System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
//		try {
//			test.addScreenCaptureFromPath(screenshotPath);// adding screenshot
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// adding screenshot

		}






	public void onTestSkipped (ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName());

		
	}
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
		
	}
	
}
