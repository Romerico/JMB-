package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class MyProfilePage extends BasePage{
	public MyProfilePage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[3]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement CandidateTeaserEditbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[2]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement EditAddressbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[3]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement EditContactbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[4]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement AddIDbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[4]/div[2]/div[1]/div[2]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement DeleteIDbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[5]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement EditWorkstatusbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[6]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement AddSkillsbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[7]/div[1]/a[1]")
	@CacheLookup
	WebElement AddEducationDetails;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[8]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement AddEmpDtlsbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[8]/div[2]/div[2]/div[2]/div[2]/div[1]/a[1]/span[1]/img[1]")
	@CacheLookup
	WebElement EditPrevElement;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[8]/div[2]/div[2]/div[2]/div[2]/div[1]/a[2]")
	@CacheLookup
	WebElement DelPrevEmpbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement Camerabtn;
	
	@FindBy(xpath="//a[contains(text(),'Terms of Service')]")
	@CacheLookup
	WebElement Termsbtn;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	@CacheLookup
	WebElement Privacybtn;
	//Edit profile
	@FindBy(id="fileName")
	@CacheLookup
	WebElement Videobtn;
	
	@FindBy(id="firstNameID")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(id="lastNameID")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(id="emailID")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	@CacheLookup
	WebElement phoneCode;
	
	@FindBy(id="country-listbox")
	@CacheLookup
	WebElement CounrtyList;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement phoneNumber;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/label[2]/span[1]")
	@CacheLookup
	WebElement Availability;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[7]/input[1]")
	@CacheLookup
	WebElement Experience;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[8]/div[1]/button[1]")
	@CacheLookup
	WebElement HighestEducation;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/button[1]")
	@CacheLookup
	WebElement Savebtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]")
	@CacheLookup
	WebElement Cancelbtn;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/label[1]/span[1]")
	@CacheLookup
	WebElement mailID;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/h3[1]")
	@CacheLookup
	WebElement name;
	
	
	
	public void EditCandidateTeaser()
	{
		CandidateTeaserEditbtn.click();
	}
	
	public void EditAddress()
	{
		EditAddressbtn.click();
	
	}
	public void EditContact()
	{
		EditContactbtn.click();
	}
	public void AddID()
	{
		AddIDbtn.click();
	}
	public void DeleteID()
	{
		DeleteIDbtn.click();
	}
	public void EditWorkstatus()
	{
		EditWorkstatusbtn.click();
	}
	public void AddSkills()
	{
		AddSkillsbtn.click();
	}
	public void AddEducationDetails()
	{
		AddEducationDetails.click();
	}
	
	public void AddEmpDtls()
	{
		AddEmpDtlsbtn.click();
	}
	
	public  void EditPrevElement()
	{
		EditPrevElement.click();
	}
	public void DelPrevEmp()
	{
		DelPrevEmpbtn.click();
	}
	public void Camera()
	{
		Camerabtn.click();
	}
	public void Terms()
	{
		Termsbtn.click();
	}
	public void Privacy()
	{
		Privacybtn.click();
	}

	public void EditCandidateTeaser(String Fname,String Lname,String PhnCode,String PhNo,String Exp,String Degree) throws InterruptedException
	{	
	    FirstName.clear();
		FirstName.sendKeys(Fname);	
		lastName.clear();
		lastName.sendKeys(Lname);
		phoneCode.click();
		
		List<WebElement> options = CounrtyList.findElements(By.tagName("li"));		
		for (WebElement option : options)
		{
			String Ctext=option.getText();
			System.out.println(Ctext);
		    if (Ctext.equals(PhnCode))
		    {		    	
		        option.click();// click the desired option		      
		        break;
		    }
		}
		Thread.sleep(1000);
		phoneNumber.clear();
		Thread.sleep(1000);
		phoneNumber.sendKeys(PhNo);
		Thread.sleep(1000);
		Experience.clear();
		Experience.sendKeys(Exp);
		Thread.sleep(1000);
		HighestEducation.click();
		List<WebElement> options1 = HighestEducation.findElements(By.tagName("li"));
		for (WebElement option1 : options1)
		{
		    if (option1.getText().equals(Degree))
		    {
		        option1.click(); // click the desired option
		        break;
		    }
		}	
				
	}
	
	public String name()
	{
		String nametxt=name.getText();
		return nametxt;
	}
	
	public String emaild()
	{
		String mailIdtxt=mailID.getText();
		return mailIdtxt;
	}
	public void save()
	{
		Savebtn.click();
	}
	public void Cancelbtn()
	{
		Cancelbtn.click();
	}
} 