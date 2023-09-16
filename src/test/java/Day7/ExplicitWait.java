package Day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*  if the condition is true then it will proceed, if the condition is not true
    then it will wait for wait time
    0 sec is default time
    waittime - 10 sec is usually used standard
 
    duration- class
    visibility of - method of expected condition class 
    expected condition- class
    Adv- 1. It works on the basis of condition so it will work more effectively.
         2. Findelement method is inclusive, so dont need to write it
    Dis- 1. Need to write a separate statement for each element (multiple times)
    
 */

public class ExplicitWait {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
        //declaring explicit wait only single time
		WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
	   
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		WebElement element1= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	    element1.sendKeys("Admin");
		WebElement ele2= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	    ele2.sendKeys("Admin");
	    
	
	
	}

}
