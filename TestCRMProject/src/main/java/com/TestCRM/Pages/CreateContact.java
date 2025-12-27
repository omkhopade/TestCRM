package com.TestCRM.Pages;


import java.util.LinkedHashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Helper;
import com.TestCRM.TestUtils.JavaScripts;
import com.TestCRM.TestUtils.ReadDataFromExcel;
import com.TestCRM.TestUtils.Timers;

public class CreateContact extends TestBase{
	
	LinkedHashMap<String , String> map;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]//parent :: a")
	 WebElement Contaclink;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	 WebElement CreateButton;
	
	
	@FindBy(name = "first_name")
	 WebElement firstname;
	
	@FindBy(name = "last_name")
	 WebElement LastName;
	
	@FindBy(name = "middle_name")
	 WebElement middileName;
	
	
	@FindBy(xpath="//div[@name='company']/input")
	 WebElement company;
	
	@FindBy(xpath = "//input[@name='value' and @placeholder='Email address'] ")
	 WebElement email;
	
	@FindBy(xpath = "//button[starts-with(text(),'Save')]")
	WebElement save;
	
	@FindBy(xpath = "//label[contains(text(),'First Name')]/span")
	WebElement FirstNameVerify;
	
	@FindBy(xpath = "//label[contains(text(),'Last Name')]/span")
	WebElement LastNameVerify;
	
	@FindBy(xpath = "//label[text()='Tags']/parent :: div //input")
	WebElement tags;
	
	@FindBy(xpath = "//label[text()='Status']/parent :: div / div")
	WebElement status;
	
	@FindBy(xpath  = "//div[@class='visible menu transition']/div/span")
	List<WebElement> list;	
	
	@FindBy(name = "channel_type")
	WebElement socialChannel;
	
	@FindBy(xpath = "//div[@class='visible menu transition']/div/span")
	List<WebElement> listSocial;
	
	@FindBy(xpath = "//div[@name='timezone']/input")
	WebElement TimeZone;
	
	@FindBy(name="address")
	WebElement street;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name = "zip")
	WebElement zipcode;
	
	@FindBy(xpath = "//div[@name='country']//input")
	WebElement country;
	
	@FindBy(xpath ="//div[@class='visible menu transition']/div/span")
	List<WebElement> countrylist;
	
	@FindBy(xpath = "//input[@name='do_not_call'  and @type='checkbox']")
	WebElement call;
	
	@FindBy(xpath = "//input[@name='fileField']")
	WebElement image;
	
	@FindBy(name = "category")
	WebElement Category;
	
	@FindBy(xpath="//div[@class='visible menu transition']/div/span")
	List<WebElement> categorylist;
	
	
	
	
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
		
		map = ReadDataFromExcel.getData("TC_01 Verify that user is able to add contact",".//TestData//CRMTestData.xlsx","Sheet1");
		Helper.sendKeystoWebElement(firstname,map.get("First Name"));
		Helper.sendKeystoWebElement(middileName, map.get("LastName"));
		Helper.sendKeystoWebElement(LastName,map.get("Middle Name"));
		Helper.sendKeystoWebElement(email,map.get("Company Name"));
		Helper.sendKeystoWebElement(company,map.get("Email"));
		status.click();
		Helper.clickOnDropDown(list,map.get("Status"));
		socialChannel.click();
		Helper.clickOnDropDown(listSocial,map.get("Social"));
		TimeZone.sendKeys("India");
		Helper.sendKeystoWebElement(street,"Johnsburg");
		city.sendKeys("Amstradam");
		state.sendKeys("Maharashtra");
		zipcode.sendKeys("411201");
		JavaScripts.clickElement(country);
		Helper.clickOnDropDown(countrylist,"Afghanistan");
		JavaScripts.scrollTillElement(call);
		Helper.clickWebEelement(driver, call);
		JavaScripts.scrollTillElement(image);
		image.sendKeys("C:\\Users\\Admin\\Desktop\\win.JPG");
		JavaScripts.scrollTillElement(Category);
		JavaScripts.clickElement(Category);
		Helper.clickOnDropDown(categorylist,map.get("Category"));
		
		
		
		
		
		Timers.takeScreenShotsOnFailed();
			
		//Helper.clickWebEelement(driver, save);
		
		//Timers.smallStaticWait();
		
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
