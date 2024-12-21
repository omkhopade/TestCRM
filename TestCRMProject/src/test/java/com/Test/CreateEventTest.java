package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestCRM.Pages.CalendarPage;
import com.TestCRM.Pages.LoginPage;
import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Timers;

public class CreateEventTest extends TestBase {
	
	LoginPage loginpage;
	CalendarPage calender;
	
	public CreateEventTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initilisation();
		loginpage = new LoginPage();
		loginpage.verifyLogin();
		calender = new CalendarPage();
		
	}
	
	
	@Test(enabled = true , priority = 1)
	public void verifyCreateContactValidations() throws InterruptedException
	{
		
		calender.verifyCreateEventPage();
		
	}
	@AfterMethod
	public void tearDown()
	{
		Timers.smallStaticWait();
		driver.quit();
	}
	

}
