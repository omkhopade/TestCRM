package com.TestCRM.TestUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.TestCRM.TestBase.TestBase;

public class Timers extends TestBase{

	
	public static long implicitwait=40;
	public static long pageloadTimeOut=20;
	
	
	
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
	
	
	
	
	
	
	
	
	
}
