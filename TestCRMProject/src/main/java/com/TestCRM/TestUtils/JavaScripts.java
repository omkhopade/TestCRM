package com.TestCRM.TestUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.TestCRM.TestBase.TestBase;

public class JavaScripts extends TestBase {

	public static JavascriptExecutor js= ((JavascriptExecutor) driver);
	
	public static  void borderElement(WebElement element)
	{
		js.executeScript("arguments[0].style.border='4px solid red'", element);
	}
	
}
