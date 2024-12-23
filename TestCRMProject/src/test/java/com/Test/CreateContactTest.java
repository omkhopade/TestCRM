package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestCRM.Pages.CreateContact;
import com.TestCRM.Pages.LoginPage;
import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Logs;
import com.TestCRM.TestUtils.Timers;

public class CreateContactTest extends TestBase{

	
	LoginPage loginpage;
	CreateContact contactobj;

	
	public CreateContactTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initilisation();
		loginpage = new LoginPage();
		contactobj = new CreateContact();
		loginpage.verifyLogin();
		
	}
	
	
	@Test(enabled = true , priority = 1)
	public void verifyCreateContactValidations()
	{
		contactobj.verifyLandOnCreateContactPage();
		Logs.runTimeInfo("info", "info");
		contactobj.verifyvalidation();
		Logs.runTimeInfo("info", "info");
		
		
	}
	@Test(priority = 2, enabled = true)
	public void verifyCreateContact()
	{
		contactobj.verifyLandOnCreateContactPage();
		Logs.runTimeInfo("info", "info");
		contactobj.verifyCreateContact();
		Logs.runTimeInfo("info", "info");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		Timers.smallStaticWait();
		driver.quit();
	}
}
