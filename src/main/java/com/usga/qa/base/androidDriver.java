package com.usga.qa.base;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class androidDriver extends BaseClass
{	
   
protected AndroidDriver driver;

public androidDriver()
{
	this.driver=super.getAndroiddriver();
	
}
public static String takescreenshot(String testName, AppiumDriver driver)
{
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	
}

}
