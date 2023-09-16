package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest_OrangeHRM {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(chromeOption);
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin13");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    Thread.sleep(10000);
	String actual_title = null;
    try 
	{   
	actual_title = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(); 	
	}
	catch(NoSuchElementException e)
	{
		 actual_title = " ";
	}
	
    String exp_title= "Dashboard";


    
    if (exp_title.equals(actual_title))	
	{
    	        System.out.println("Login is successful");
    		}
    else 

    {	System.out.println("Login is failed");

    } 
   driver.close();


	}

}
