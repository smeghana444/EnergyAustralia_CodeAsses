
package com.usga.qa.base;


import java.io.File;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class BaseClass
{
	 static Properties property;
	 protected static AndroidDriver driver=null;
	 private static String platformnameandroid = propertiesclass.initializeproperties("platformNameAndroid");
	 private static AppiumDriverLocalService  service;
	 private static String apkfile=System.getProperty("user.dir")+"/src/main/java/com/usga/qa/testdata/RecordLabelApp.apk";
	
	public AndroidDriver getAndroiddriver()
	{
		return (AndroidDriver) driver;
	}
	
	public static void androidinitialization() throws Exception
	{
		if(platformnameandroid.equalsIgnoreCase("Android"))
		{
		 System.out.println(platformnameandroid);
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformnameandroid);
         desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
         desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
         desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
         desiredCapabilities.setCapability(MobileCapabilityType.APP, apkfile);
         startServer();
         System.out.println(service.getUrl());
         driver = new AndroidDriver(service.getUrl(), desiredCapabilities);                
         System.out.println("Launch the app in Android ");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));        
         }       	     
		else 
		{
       	 System.out.println("No android device Found");
        }
	}	
	
	
	public static void startServer () 
	{
       	AppiumServiceBuilder builder = new AppiumServiceBuilder ();
        builder         
            .withAppiumJS (
                new File ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
            .usingDriverExecutable (new File ("/usr/local/bin/node"))
            .withIPAddress ("127.0.0.1")
            .usingPort (4723)  
            .withArgument (BASEPATH, "/wd/hub")
            .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument (GeneralServerFlag.LOG_LEVEL, "debug")
            .withLogFile(new File("Appiumlog.txt"));

        service = AppiumDriverLocalService.buildService (builder);
        service.start ();
		
    }
	public static void stopServer ()
	{
		service.stop();		
    }
	public static void scroll(int scrollStart, int scrollEnd) {
	    try {
			new TouchAction((PerformsTouchActions)driver)
			        .press(PointOption.point(0, scrollStart))
			        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
			        .moveTo(PointOption.point(0, scrollEnd))
			        .release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

