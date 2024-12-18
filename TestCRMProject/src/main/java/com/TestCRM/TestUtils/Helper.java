package com.TestCRM.TestUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestCRM.TestBase.TestBase;

public class Helper  extends TestBase{

	
	
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions action= new Actions(driver);
		action.moveToElement(element);
	}
	
	
	public static void clearTextField(WebElement element)
	{
		element.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
	
	}
	
	
	public static void clickWebEelement(WebDriver driver , WebElement element)
	{
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	
	public static void sendKeystoWebElement(WebElement element, String value)
	{
		
		element.sendKeys(value);
	}
	
	
}
