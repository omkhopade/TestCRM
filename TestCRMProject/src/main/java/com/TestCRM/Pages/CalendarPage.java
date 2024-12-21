package com.TestCRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestCRM.TestBase.TestBase;
import com.TestCRM.TestUtils.Helper;

public class CalendarPage extends TestBase{

	
	@FindBy(id ="main-nav")
	WebElement menu;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]/ parent :: a ")
	WebElement calendar;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement createbutton;
	
	@FindBy(name = "title")
	WebElement eventTitle;
	
	@FindBy(xpath = "//label[text()='Start Date']/ parent  :: div //input")
	WebElement startdatebutton;
	
	@FindBy(xpath="//div[@class='react-datepicker__month-container']//div[@class='react-datepicker__current-month']")
	WebElement MonthText;
	
	@FindBy(xpath = "//span[text()='Previous Month'] /parent :: button")
	WebElement prevMonth;
	
	@FindBy(xpath = "//div[@class='react-datepicker__month']/div")
	List<WebElement> rows ;
	
	@FindBy(xpath = "//div[@class='react-datepicker__month']/div[2]/div")
	List<WebElement> cell;
	
	@FindBy(xpath ="//ul[@class='react-datepicker__time-list']/li")
	
	List<WebElement> timelist;
	
	@FindBy(xpath = "//label[text()='End Date']/ parent :: div // input")
	WebElement EndDatebutton;
	
	@FindBy(xpath = "//button/span[text()='Next Month']/parent :: button")
	WebElement nextMonth;
	
	
	
	
	
	
	
	
	
	public CalendarPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void verifyCreateEventPage() throws InterruptedException
	{
		menu.click();
		calendar.click();
		createbutton.click();
		startdatebutton.click();
		
		while(!MonthText.getText().equals("October 2024"))
		{
			Thread.sleep(1000);
			prevMonth.click();
		}
		boolean flag=false;
		for(int i=1;i<=rows.size();i++)
		{
			for(int j=1;j<=cell.size();j++)
			{
				String date=driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).getText();
				System.out.println(date);
				if(date.equals("25"))
				{
					driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).click();
					Thread.sleep(1000);
					flag=true;
					break;
				}
				
				
				
			}
			
			if(flag==true)
			{
				break;
			}
		}
		
		Helper.clickOnDropDown(timelist, "01:45");
		
		EndDatebutton.click();
		while(!MonthText.getText().equals("March 2025"))
		{
			Thread.sleep(1000);
			nextMonth.click();
		}
		boolean flag1=false;
		
		int EndDate=25;
		if(EndDate > 17 )
		{
		for(int i=3;i<=rows.size();i++)
		{
			for(int j=1;j<=cell.size();j++)
			{
				String date=driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).getText();
				System.out.println(date);
				String endDate=Integer.toString(EndDate);
				if(date.equals(endDate))
				{
					driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).click();
					Thread.sleep(1000);
					flag1=true;
					break;
				}
				
				
				
			}
			
			if(flag1==true)
			{
				break;
			}
		}
		}
		
		else
		{
			for(int i=1;i<=rows.size();i++)
			{
				for(int j=1;j<=cell.size();j++)
				{
					String date=driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).getText();
					System.out.println(date);
					String endDate=Integer.toString(EndDate);
					if(date.equals(endDate))
					{
						driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div["+i+"]/div["+j+"]")).click();
						Thread.sleep(1000);
						flag1=true;
						break;
					}
					
					
					
				}
				
				if(flag1==true)
				{
					break;
				}
			}
		}
		Helper.clickOnDropDown(timelist, "01:45");
		
		
		
	
	
	
	}
	
	
	
}
