package com.TestCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestCRM.TestBase.TestBase;

public class CalendarPage extends TestBase{

	
	@FindBy(id ="main-nav")
	WebElement menu;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]/ parent :: a ")
	WebElement calendar;
	
	
	
	
	
	public CalendarPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
}
