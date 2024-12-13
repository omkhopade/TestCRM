package com.TestCRM.TestBase;

import javax.naming.Context;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestCRM.TestUtils.Timers;

public class MyTestNgListerners implements ITestListener{

	public void onTestStart(ITestResult result) {
	   
		System.out.println("method name "+result.getName()+" started.... ");
		
	  }
	
	public void onTestFailure(ITestResult result) {
	    
		Timers.takeScreenShots();
		System.out.println("Failed Method "+ result.getName() );
		
	  }
	
}
