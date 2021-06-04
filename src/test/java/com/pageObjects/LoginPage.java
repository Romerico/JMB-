package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Capture email field
	@FindBy(id = "email")
	@CacheLookup
	WebElement txtemail;

	// Capture password field
	@FindBy(id = "password-field")
	@CacheLookup
	WebElement txtpassword;

	// Capture Submit button
	@FindBy(id = "sbBt")
	@CacheLookup
	WebElement btnSubmit;

	// Capture "invalid credentials text"
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/span[1]")
	@CacheLookup
	WebElement blankEmailText;
	
	//Capture "invalid password text"
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[2]/div[1]/div[1]/span[1]")
	@CacheLookup
	WebElement blankpwdText;
	
	//Capture invalid 
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[1]/div[2]")	
	@CacheLookup
	WebElement invalidCredentialsText;
	
	// Capture "sign up" link in login page
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/nav/ul/li/a")
	@CacheLookup
	WebElement signUpLink;

	// Capture "candidate sign up" link in login page
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/nav/ul/li/div/div/a[1]")
	@CacheLookup
	WebElement candidateSignUpLink;

	// Capture "forgot password" link
	@FindBy(xpath = "//*[@id=\"candidateLogin\"]/div[3]/div[3]/div[1]/a")
	@CacheLookup
	WebElement forgotPasswordLink;
	
	//capture popup
		@FindBy(xpath="/html[1]/body[1]/section[1]/div[3]/div[1]/div[1]/div[1]/span[1]")
		@CacheLookup
		WebElement popup;

	// ==================Action methods===========================//

	// Send text to the email field
	public void settxtemail(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
	}

	// Send text to password field
	public void settxtpassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(pwd);
	}

	// Click on submit button
	public void clkbtnSubmit() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(btnSubmit));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
	}

	// display "invalid credentials" message
	public Boolean displayInvalidCredentialsMessage() {
		return invalidCredentialsText.isDisplayed();
	}

	// click on sign up link
	public void clickOnSignUpLink() {
		signUpLink.click();
	}

	// click on candidate sign up link
	public void clickOnCandidateSignUpLink() {
		candidateSignUpLink.click();
	}

	// click on forgot password link
	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	// to display email text box in login page
	public Boolean isEmailTextBoxDisplayed() {
		return txtemail.isDisplayed();
	}

	// to display password text box in login page
	public Boolean isPasswordTextBoxDisplayed() {
		return txtpassword.isDisplayed();
	}

	// to display submit button in login page
	public Boolean isSubmitButtonDisplayed() {
		return btnSubmit.isDisplayed();
	}
	
	public void Closepopup()
	{
		popup.click();
	}
	public String blankEmail()
	
	{
		String txt=blankEmailText.getText();
		return txt;
	}
	
	public String blankPwd()
	{
		String txt1=blankpwdText.getText();
		return txt1;
	}

	public String InvalidCreds()
	{
		String txt3=invalidCredentialsText.getText();
		return txt3;
	}
}
