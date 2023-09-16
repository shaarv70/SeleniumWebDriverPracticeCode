package Day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*  Implicit wait works on the basis of time
    Adv-1.implicit wait will be applicable for every element in the script
       2.it will not wait for maximum time, it will wait for the time until the element is 
       located otherwise we will get exception
       3. easy to use 
   Dis- if time is not sufficient then will get exception
 */

public class ImplicitWait {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		// we need to declare implicit wait only single time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");

	}

}
