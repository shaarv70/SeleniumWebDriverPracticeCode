package Day17TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 Crossbrowser testing- Running the test on multiple browsers.This can be achieved serially/sequentially
 or parallely.
 Parallel testing- Executing the same test case on multiple browsers at same time.
 This comes under parameterisation concept under second category "xml file" 
 Steps:1. create test
 2.Create an xml file to run the test
 3.Pass the browser name parameter from xml to setup method().
 4.Execute test on chrome and edge (serial execution)- in this case you need to create 2 test in xml file,
   two tests in xml,in one we can put chrome and in other test we can put edge.
 5. For parallel testing we need to add paralleln and also thread.count at suite level.

 So if we want to not hardcode the url we can also send it from xml to test method 
 as a parameter just need to add one more parameter line same as we have added browser  
 
Executing one after one test case is called serial execution.
Executing all test cases at same time is called parallel execution

Note: if we are passing some parameters from xml to test then we have to run the testcase
from xml only.
Advantages-  */

public class ParallelTesting
{
	WebDriver driver;
	
	
     @BeforeClass
     @Parameters({"browser","url"})//passing the same name as we have passed in parameter tag of  xml file
	void setup(String br,String appUrl)//Passing the arguments here automatically assigns the values of parameter tag of sml file
	{
    	 if(br.equals("chrome"))
    	 {driver=new ChromeDriver();
    	 }
    	 else if (br.equals("edge")) 
    	 {   
    		 driver=new EdgeDriver();
		}
    	 else if (br.equals("firefox"))
    	 {
    		 driver=new FirefoxDriver();
    	 }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(appUrl);
	    driver.manage().window().maximize();
	}

     @Test(priority=1)
    void testlogo() throws InterruptedException
    { 
    	Thread.sleep(4000);
    	try
    	 {
    		 boolean logo=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
    		 Assert.assertEquals(logo,true);
    	 }
    	 catch(Exception e)
    	 {
    		 Assert.fail();
    	 }
      
    }

     @Test(priority=2)
    void testHomePagetitle()
    {
    	 Assert.assertEquals(driver.getTitle(), "OrangeHRM","titles are not matching");
    	
    }
     @AfterClass
     void closeApp()
     {
    	 driver.quit();
     }
}
