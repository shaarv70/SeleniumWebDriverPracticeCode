package Day17TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/* Steps: 1) Add dependency to pom.xml
2) Create test case
3) Create Listener Class
4) Create xml file 
 */

//@Listeners (Day17TestNG.ExtentReportUtility.class) //We can integrate listener class by out test case class with this line
                                                   // this method is not useful if we have so many test cases then we have to write this line in each and every testcase
public class ExtentReport                              
{

	WebDriver driver;

	@BeforeClass
	void Setup()
	{
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	void testLogo() throws InterruptedException
	{   Thread.sleep(2500);
		try
		{
			boolean logo= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(logo,true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

	@Test (priority=2)
	void login()
	{
		try 
		{
			
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			String name= driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
			Assert.assertEquals(name,"Paul Collings","name doesn't found");
		}
		catch(Exception e)
		{
			Assert.fail();    
		}

	}
       
	  @Test(priority=3,dependsOnMethods = {"login"})
       void Logout()
       {
    	   driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
           driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
           boolean status= driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
           Assert.assertEquals(status, true);
       }

        @AfterClass 
       void tearDown()
       {
    	   driver.quit();
       }
}

