package com.TestCRM.TestUtils;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		try {
		
		Actions action = new Actions(driver);
		action.click(element).build().perform();
		
		}
		
		catch (ElementClickInterceptedException e)
		{
			System.out.println("Inside ElementClickInterceptedException catch block");
			js.executeScript("arguments[0].click()",element);
		}
		

	
	
	}
	
	
	public static void sendKeystoWebElement(WebElement element, String value)
	{
		
		element.sendKeys(value);
	}
	
	
	public static void clickOnDropDown(List<WebElement> element, String value)
	{
		List<WebElement> list = element;
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equalsIgnoreCase(value))
			{
				list.get(i).click();
				break;
			}
		}
		
	}
	
	public static String CaptureScreenShot()
	{
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		
		String base64= screenshot.getScreenshotAs(OutputType.BASE64);
		
		return base64;
	}
	
	
	
}
