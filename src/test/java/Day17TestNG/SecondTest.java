package Day17TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SecondTest 
{
	WebDriver driver;

	@Test(priority=1)/* it is used to give the sequence to method like in which order they
	                     have to be executed, it is not compulsory to give them (1,2,3),
	                     you can also give(12,13,14), But priority must be given in number only */
	void openApp()
	
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority=2)
	void Login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority=3)
	void close()
	{
         driver.quit();
	}
}
