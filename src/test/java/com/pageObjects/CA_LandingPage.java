package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class CA_LandingPage extends BasePage{
	public CA_LandingPage(WebDriver driver) {
		super(driver);
		}
	@FindBy(xpath="//header/div[2]/div[1]/nav[1]/button[1]/span[1]")
	public WebElement btnMenu;
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public WebElement btnLoginIn;
	
	public void clkbtnLogin() {
		
		btnMenu.click();		
		btnLoginIn.click();
	
	}
}
