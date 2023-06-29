package com.usga.qa.androidscreens;



import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.usga.qa.base.ExtentTestManager;
import com.usga.qa.base.androidDriver;
import io.appium.java_client.MobileBy;




public class VerifyBand_and_FestivalNames extends androidDriver
{
	pageObjects getnames;

   public VerifyBand_and_FestivalNames() 
	{
        super();

    getnames = new pageObjects();

  PageFactory.initElements(driver, getnames);

   }
   class pageObjects
   {
	   @FindBys(
				@FindBy(xpath="//android.widget.TextView[@resource-id='com.energyaustralia.codingtestsample:id/titleTextView']")) 
				public List<WebElement> bandnames;
	   
	 
	   @FindBys(
				@FindBy(xpath="//android.widget.TextView[@resource-id='com.energyaustralia.codingtestsample:id/festivalTextView']")) 
				public List<WebElement> festivalsnames;
	   
   }
	
public void verifyfestivalsnames(String festivalname) throws Exception
	
	{
		List<WebElement> verifyfestivalsband=getnames.festivalsnames;
		int similarfestivalname=0;  
        int size=verifyfestivalsband.size();
        System.out.println("size is " +size);
        System.out.println(size);
        for (int i = 0; i <size; i++) 
        {
            String printfestivalname = verifyfestivalsband.get(i).getText();
            System.out.println(printfestivalname);
            ExtentTestManager.getTest().log(Status.INFO, printfestivalname);
            Thread.sleep(1000);
            if (printfestivalname.equals(festivalname)) 
            {
         	System.out.println("Festival Name Matched");
         	ExtentTestManager.getTest().log(Status.INFO, printfestivalname+ " festival Name Matched with "+festivalname);
         	similarfestivalname++;
         	System.out.println(festivalname+" Festivalname is similar" + similarfestivalname + "times");
         	ExtentTestManager.getTest().log(Status.INFO, festivalname+" festivalname is similar for " + similarfestivalname + " times");
            Thread.sleep(3000);
            }
                    
        }
       if(size==0)
  	   {
  		 
  		  ExtentTestManager.getTest().log(Status.INFO, " festival name not matched: Unknown ");
  	   }
	}
public void verifybandnames(String bandname, String scrolltillbandname) throws Exception

{
	
	List<WebElement> verifybandnames=getnames.bandnames;
	int similarbandname=0;  
    int size=verifybandnames.size();
    System.out.println(size);
    for (int i = 0; i <size; i++) 
    {
        String printbandname = verifybandnames.get(i).getText();
        System.out.println(printbandname);
        ExtentTestManager.getTest().log(Status.INFO, printbandname);
        Thread.sleep(1000);
        if (printbandname.equals(bandname)) 
        {
     	System.out.println("Band Name Matched");
     	ExtentTestManager.getTest().log(Status.INFO, printbandname+ " Band Name Matched with " +bandname);
     	similarbandname++;
     	System.out.println(bandname+" Bandname is similar" + similarbandname +"times");
     	ExtentTestManager.getTest().log(Status.INFO, bandname+ " Bandname is similar for " + similarbandname + " times");
        Thread.sleep(3000);
          
        }
       else if(printbandname.equalsIgnoreCase("Response wasn't successful or data empty. Response code: 429")|| printbandname.contains("Something Went Wrong"))
        	
 	   {
 		  System.out.println(printbandname+ " bandname not matched with" +bandname);
 		  ExtentTestManager.getTest().log(Status.INFO," bandname not matched");
 	   }
        if(size==i+1)
        {
    	   driver.findElement(MobileBy
                   .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                           + "new UiSelector().text(\""+scrolltillbandname+"\"));"));
        }
    }
}

}

