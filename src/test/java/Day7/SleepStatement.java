package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Wait statement will be used to solve synchronisation problem in automation
   Thread.Sleep is not a wait statement because it comes from java

 */

public class SleepStatement {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");

		/*
		  Advantage- easy to use
		  disa- if time is not suff then will get exception
		        it will wait for maximum timeout, this will reduce the performance of the execution
		        has to be used multiple times 
		 */ 



	}

}
