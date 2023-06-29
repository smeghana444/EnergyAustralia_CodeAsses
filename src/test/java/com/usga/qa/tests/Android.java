package com.usga.qa.tests;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.usga.qa.androidscreens.VerifyBand_and_FestivalNames;
import com.usga.qa.base.BaseClass;
import com.usga.qa.base.ReadDataFromExcel;


public class Android extends ReadDataFromExcel
{
public String repName;
public ExtentHtmlReporter sparkReporter;
public ExtentReports extent;

	@BeforeClass
	public void setup() throws Exception
	{
		
		BaseClass.androidinitialization();
		AssertJUnit.assertTrue(true);
	}

	
	@Test(priority=1,retryAnalyzer= Rerunfailedscripts.class,dataProvider = "getTestData")
	public void VerifyFestivalName(String bandname, String festivalname, String scrolltilltext) throws Exception
	{
	
	VerifyBand_and_FestivalNames getstarted=new VerifyBand_and_FestivalNames();
	getstarted.verifyfestivalsnames(festivalname);
	AssertJUnit.assertTrue(true);
		
}
	@Test(priority=2,retryAnalyzer= Rerunfailedscripts.class,dataProvider = "getTestData")
	public void VerifyBandName(String bandname, String festivalname, String scrolltillbandname) throws Exception
	{
	
	VerifyBand_and_FestivalNames getstarted=new VerifyBand_and_FestivalNames();
	getstarted.verifybandnames(bandname,scrolltillbandname);
	AssertJUnit.assertTrue(true);
	
	
	
}
}