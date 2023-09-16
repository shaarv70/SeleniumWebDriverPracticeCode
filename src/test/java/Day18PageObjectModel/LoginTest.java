package Day18PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest 

{   WebDriver driver;
    PageObjectLogin lp;
  //  PageObjectFactory lp2;cjust create in the same way as done in normal approach
    
@BeforeClass
void setup() throws InterruptedException
{
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();
    Thread.sleep(3000);
}

@Test(priority=1)
void logo_check()
{
	//lp = new PageObjectLogin(driver);
//	lp2= new PageObjectFactory(driver);//object created for page object factory 
	Assert.assertEquals(lp.checkLogo(), true,"logo is not matched");
	
}
@Test(priority=2)
void login()
{    
	lp.setUsername("Admin");
	lp.setPassword("admin123");
    lp.clickBtn();
}

@Test(priority=3)
void validation() throws InterruptedException
{    
	Thread.sleep(2500);
	String text= driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
    Assert.assertEquals(text,"Dashboard","Login is not successful");
}

@AfterClass
void tearDown()
{
	driver.quit();
}

}
