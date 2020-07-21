package com.TestCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestCRM.TestBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//div[@class='rd-navbar-nav-wrap toggle-original-elements']//ul//a//span[contains(text(),'Log In')]")
	WebElement loginButton;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[starts-with(text(),'Login')]")
	WebElement login;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginButton()
	{
		loginButton.click();
	}
	
	public EditProfilePage verifyLogin()
	{
		email.sendKeys(pro.getProperty("email"));
		password.sendKeys(pro.getProperty("password"));
		login.click();
		 return new EditProfilePage();
		 
	}
	
}
