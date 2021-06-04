package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	public WebDriver ldriver;

	// Constructor

	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Capture Signup heading
	@FindBy(xpath="//h2[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement SignUp;
	
	//Capture image
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/img[1]")
	@CacheLookup
	WebElement image;
	
	//Capture Signupform
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[2]/form[1]/div[2]")
	@CacheLookup
	WebElement form;

	// Capture FirstName field
	@FindBy(id="firstname")
	@CacheLookup
	WebElement txtfirstname;
	
	// Capture lastname field
	@FindBy(id="lastname")
	@CacheLookup
	WebElement txtLastName;
	
	// Capture email field
	@FindBy(id="email")
	@CacheLookup
	WebElement txtemail1;
	
	//Capture phone dial code
	@FindBy(xpath="//body/div[2]/div[2]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]")
	@CacheLookup
	WebElement txtdialCode;
	
	//Capture Countrylist
	@FindBy(xpath="//body/div[2]/div[2]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]")
	@CacheLookup
	WebElement countrylist;
	
	//Capture PhoneNumber
	@FindBy(xpath="//input[@id='phone']")
	@CacheLookup
	WebElement txtPhoneNumber;
	
	//Capture Password
	@FindBy(id="password-field")	
	@CacheLookup
	WebElement txtpassword;
	
	//Capture SHOW password
	@FindBy(xpath="//a[contains(text(),'show')]")
	@CacheLookup
	WebElement showpswd;
	
	//Capture TermsofService
	@FindBy(xpath="//body/div[2]/div[2]/div[2]/form[1]/div[2]/div[5]/div[1]/label[1]")
	@CacheLookup
	WebElement chbxagreeTerms;
	
	//Capture PrivacyPolicy
	@FindBy(xpath="//body/div[2]/div[2]/div[2]/form[1]/div[2]/div[6]/div[1]/label[1]")
	@CacheLookup
	WebElement chbxPrivacyPolicy;
	
	//Capture Im not Robot
	@FindBy(id="recaptcha1")
	@CacheLookup
	WebElement chbxRobot;
	
	//Capture SignUp button
	@FindBy(id="sbBt")
	@CacheLookup
	WebElement btnJoinNow;
	
	//Capture LogIn link
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	@CacheLookup
	WebElement linkLogIn;
	
	
	
public void candidateSignUp(String FstName,String LstName,String emailid,String PhNo,String pswd  ) throws InterruptedException
{

	txtfirstname.sendKeys(FstName);
	Thread.sleep(1000);
	txtLastName.sendKeys(LstName);
	Thread.sleep(1000);
	txtemail1.sendKeys(emailid);
	Thread.sleep(1000);		
	txtPhoneNumber.sendKeys(PhNo);
	Thread.sleep(1000);
	txtpassword.sendKeys(pswd);
	Thread.sleep(1000);
	showpswd.click();
	Thread.sleep(1000);
	chbxagreeTerms.click();
	Thread.sleep(1000);
	chbxPrivacyPolicy.click();
	Thread.sleep(1000);
	chbxRobot.click();
	Thread.sleep(20000);
	WebDriverWait wait = new WebDriverWait(ldriver, 2500);
	wait.until(ExpectedConditions.visibilityOf(btnJoinNow));
	btnJoinNow.click();
}

public Boolean isSignupDisplayed() {
	return SignUp.isDisplayed();
}

public Boolean isImageDisplayed() {
	return image.isDisplayed();
}
public Boolean isFormDisplayed() {
	return form.isDisplayed();
}
}