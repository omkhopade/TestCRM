package com.TestCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.JavaScripts;
import com.TestCRM.TestUtils.Timers;

public class EditProfilePage  extends TestBase{
	
	@FindBy(xpath="//a[starts-with(text(),'Amruta')]")
	WebElement selectname;
	
	@FindBy(xpath="//button[@class='ui icon button']//i[@class='edit icon']")
	WebElement editprofile;
	
	@FindBy(name="middle_name")
	WebElement middlename;
	
	@FindBy(xpath="//div[@name='company']//input")
	WebElement company;
	
	@FindBy(xpath="//div[@role='option']//span[starts-with(text(),'tcs')]")
	WebElement tcs;
	
	@FindBy(name = "category")
	WebElement category;
	
	@FindBy(xpath="//div[@role='option']//span[starts-with(text(),'Lead')]")
	WebElement role;
	
	@FindBy(name = "status")
	WebElement status;
	
	@FindBy(xpath="//div[@role='option']//span[starts-with(text(),'Active')]")
	WebElement active;
	
	@FindBy(name="address")
	WebElement street;
	
	@FindBy(name ="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="zip")
	WebElement zip;
	
	@FindBy(xpath="//div[@name='country']//input")
	WebElement country;
	
	@FindBy(xpath="//div[@class='visible menu transition']//div[@role='option']//span[starts-with(text(),'India')]")
	WebElement india;
	
	@FindBy(xpath="//button[@class='ui linkedin button'  and contains (text(),'Save')]")
	WebElement savebutton;
	
	
	public EditProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void updateProfile()
	{
		selectname.click();
		editprofile.click();
		middlename.clear();
		middlename.sendKeys("Akshay");
		company.sendKeys("tcs");
		tcs.click();
		category.click();
		role.click();
		status.click();
		active.click();
		street.clear();
		street.sendKeys("James harbaer road");
		city.clear();
		city.sendKeys("manchester");
		state.clear();
		state.sendKeys("calefornia");
		zip.clear();
		zip.sendKeys("521463");
		country.sendKeys("india");
		Timers.smallStaticWait();
		india.click();
	
	}
	
	public void submitChnages()
	{
		JavaScripts.borderElement(savebutton);
		Timers.smallStaticWait();
		savebutton.click();
	}
	
	
	
}
