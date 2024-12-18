package com.TestCRM.Config;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.TestCRM.TestUtils.Timers;

public class MyTestNgList implements ITestListener{

	
	public  void onTestStart(ITestResult result) {
	     System.out.println("Started Test "+ result.getName());
	  }
	
	
	public void onTestSuccess(ITestResult result) {
	    
		Timers.takeScreenShotsOnPass();
		System.out.println("Pass Test "+ result.getName());
	  }

	public void onTestFailure(ITestResult result) {
		
		Timers.takeScreenShotsOnFailed();
	    System.out.println("Failed test "+ result.getName());
	  }
	
}
