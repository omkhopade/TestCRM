package com.TestCRM.TestUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.TestCRM.TestBase.TestBase;

public class JavaScripts extends TestBase {

	//public static JavascriptExecutor js= ((JavascriptExecutor) driver);
	
	public static  void borderElement(WebElement element)
	{
		js.executeScript("arguments[0].style.border='4px solid red'", element);
	}
	
	
	public static void clickElement(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
}
