package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BasePage;

public class CA_LandingPage extends BasePage{
	public CA_LandingPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public WebElement btnLoginIn;
	
	@FindBy(xpath="//header/div[2]/div[1]/nav[1]/div[1]/ul[2]/li[2]/a[1]")
	public WebElement btnSignUp;
	
	@FindBy(xpath="//a[contains(text(),'Candidate Sign Up')]")
	public WebElement btnCandidateSignUp;
	
	@FindBy(xpath="//a[contains(text(),'Jobs')]")
	public WebElement Jobs;
	
	public void clkbtnLogin() {
		
			
		btnLoginIn.click();
	
	}
	public void clkbtnSignUp() {
		
		btnSignUp.click();
	}
	public void clkbtnCandidateSignUp() {
		
		btnCandidateSignUp.click();
	}
	public void FindJobs()
	{
		Jobs.click();
	}
	
}
