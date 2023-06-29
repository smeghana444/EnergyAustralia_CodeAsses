package com.usga.qa.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerunfailedscripts implements IRetryAnalyzer

{
	private int retrycount=0;
	private static final int maxcount=0;
	public boolean retry(ITestResult result) {
	if(retrycount<maxcount)
	{
		retrycount++;
		return true;
	}
		
		return false;
	}

}
