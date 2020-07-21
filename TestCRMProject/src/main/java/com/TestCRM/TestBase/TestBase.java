package com.TestCRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestCRM.TestUtils.Timers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties pro;
	
	public TestBase()
	{
		pro = new Properties();
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(".\\src\\main\\java\\com\\TestCRM\\Config\\ConfigProperties.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pro.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void installation()
	{
		
		if(pro.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if(pro.getProperty("fireFox").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Timers.implicitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Timers.pageloadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		
	
	}
	
}
