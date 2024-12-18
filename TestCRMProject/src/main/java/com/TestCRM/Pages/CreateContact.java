package com.TestCRM.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Helper;
import com.TestCRM.TestUtils.Timers;

public class CreateContact extends TestBase{
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]//parent :: a")
	static WebElement Contaclink;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	static WebElement CreateButton;
	
	
	@FindBy(name = "first_name")
	static WebElement firstname;
	
	@FindBy(name = "last_name")
	static WebElement LastName;
	
	@FindBy(name = "middle_name")
	static WebElement middileName;
	
	
	@FindBy(xpath="//div[@name='company']/input")
	static WebElement company;
	
	
	@FindBy(xpath = "//input[@name='value' and @placeholder='Email address'] ")
	static WebElement email;
	
	@FindBy(xpath = "//button[starts-with(text(),'Save')]")
	WebElement save;
	
	@FindBy(xpath = "//label[contains(text(),'First Name')]/span")
	WebElement FirstNameVerify;
	
	@FindBy(xpath = "//label[contains(text(),'Last Name')]/span")
	WebElement LastNameVerify;
	
	
	public CreateContact()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLandOnCreateContactPage()
	{
		Helper.clickWebEelement(driver, Contaclink);
		Helper.clickWebEelement(driver, CreateButton);
	}
	
	public void verifyCreateContact()
	{
		
		
		Helper.sendKeystoWebElement(firstname,"Akshay");
		Helper.sendKeystoWebElement(middileName, "Abhay");
		Helper.sendKeystoWebElement(LastName,"Muley");
		Helper.sendKeystoWebElement(email,"omkardata@gmail.com");
		Helper.sendKeystoWebElement(company,"LnT");
		//Helper.clickWebEelement(driver, save);
	
	}
	
	
	public void verifyvalidation()
	{
		
		Helper.clickWebEelement(driver, save);
		Timers.smallStaticWait();
		String fname = FirstNameVerify.getText();
		String lname= LastNameVerify.getText();
		
		Assert.assertEquals(fname,"The field First Name is required.");
		Assert.assertEquals(lname, "The field Last Name is required.");
		
		
		
	}
	

}
