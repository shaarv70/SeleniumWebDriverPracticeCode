package Day7;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/*  Polling time- This time will check for the element at certain intervals of time 
    of maximum time, if we have maximum time as 50sec and polling time as 10 sec then 
    it will check after every 10 sec for the element unitil 50 sec is completed
    
    Adv- 1.Better than explicit wait because it has the concept of polling time, which 
         increases the performance of execution
         2.If exception occurs, it will handle it on its own as exception is already
         inclusive in the declaration.
         
    Dis- 1. Has to be written for each element(multiple times)
         2. complex      
    
    
 
 */

public class FluentWaitDemo {

	public static void main(String[] args) 
	{

		WebDriver driver= new ChromeDriver();
		// declaring fluent wait
		FluentWait mywait = new FluentWait(driver);
			mywait.withTimeout(Duration.ofSeconds(30));
			mywait.pollingEvery(Duration.ofSeconds(5));
			mywait.ignoring(NoSuchElementException.class);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//usage of fluent wait(old syntax not working ryt now) 
	/*	WebElement ele1 = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("//input[@name='username']"));
			}});
    
		WebElement ele2 = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("//input[@name='password']"));
			}});

		*/
		
		WebElement username=(WebElement)mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		username.sendKeys("Admin");
	}

}
