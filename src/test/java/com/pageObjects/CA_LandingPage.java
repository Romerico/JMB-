package com.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.base.BasePage;

public class CA_LandingPage extends BaseClass {

	public WebDriver ldriver;
	SoftAssert softassert = new SoftAssert();

	public CA_LandingPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	//Looking for Job WebElement
	@FindBy(xpath = "//a[@href=\"/candidates\"]")
	@CacheLookup
	WebElement candidatesBtn;

	//click the Looking for Job WebElement
	public void clickLookingForWork() {
		candidatesBtn.click();
	}

	//Looking for SignUp WebElement
	@FindBy(xpath = "//div[@class='common-btn-banner']/a[@class='btn-style']")
	@CacheLookup
	WebElement signupBtn;

	//   click sign in button on a landing page
	public void clickCandidateSignUp() {
		signupBtn.click();
	}

	//locate the sign up dropdown
	@FindBy(xpath = "//a[@class=\"nav-link\" and contains(text(), 'Sign')]")
	@CacheLookup
	WebElement singUpDropdown;
	@FindBy(xpath = "//a[text() = 'Candidate Sign Up']")
	@CacheLookup
	WebElement dropDownCandidate;

	//choose the Candidate sign up option from dropdown
	public void chooseCandidateFromDropdown() {
		singUpDropdown.click();
		dropDownCandidate.click();

	}




}
	

