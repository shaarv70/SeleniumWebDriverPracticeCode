package Day17TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* Parameterization - Passing the parameters to test method
 We have 2 approaches- 1. data provider method- When we use data driven testing, we preefer it.
 The data provider method fetch data from excel and store in 2-D Array.
 
 Advantage of data provider- We dont need to use loop we can still repeat the test method in which we are passing tjhe data number of times
 In whichevrr method we are passing the data it will execute the same number of times as we are passing the data from 
  data provider method without any loop.In every round of execution it will take different data.
  
2. XML - will discuss in ParallelTesting class in this package.  
*/

public class DataProviderDemo 
{   
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
/*@DataProvider(name="dp") - This statement will pass all the values of 2-d array to login method	
	                          this statement will work only when the test method and data provider methiod are in the same
	                          class and if we have kept both in different classes this we will study in framework */
	
	@DataProvider(name="dp", indices= {0,1,4}) /*it will pass 0,1 & 4 index values of 2-d
	                                               array to login function */	
                                                      
	String [][] loginData()                         
	{
		String data[][]= {  
							{ "abc@gmail.com", "test123" }, 
							{ "pavanol@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test3" },
							{ "pavanoltraining@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test@123" } 
						};
		
return data;   /* nhere we are returning 2-d array(which is of string type), thats why return type of function is 2-d array
	}           if we have have diiferent type of so we will take obj type of 2-d array */
	
	

}}
