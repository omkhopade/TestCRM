package com.TestCRM.TestUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestCRM.TestBase.TestBase;

public class Timers extends TestBase{

	
	public static long implicitwait=40;
	public static long pageloadTimeOut=20;
	public long explicitTime =40;
	
	
	
	public static void smallStaticWait()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeScreenShotsOnPass()
	{
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,  new File(".\\ScreenShots\\screenshots"+"pass"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeScreenShotsOnFailed()
	{
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,  new File(".\\ScreenShots\\screenshots"+"Failed"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean waitForElement(WebDriver drive, WebElement element)
	{
		
		try {
				WebDriverWait wait = new WebDriverWait(drive,explicitTime);
				wait.until(ExpectedConditions.visibilityOf(element));
				
				return true;
	
			}
		
		catch (TimeoutException e) {
			
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
}
