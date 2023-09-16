package Day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// frame-- it is related to the webpage
// syntax -- driver.switchTo.frame(name attribute value/id attribute value)

public class HandleFrames_By_ID_and_name {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		
		//switching to frames through name and id attribute
		// switching to frame- 1 
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
	
	    // before going to next frame first we have to go back to webpage then go to particular frame 
		driver.switchTo().defaultContent();
		
		// switching to frame-2
	     driver.switchTo().frame("packageFrame");
	     
	     driver.findElement(By.xpath("//span[contains(text(),'WebDriver')]")).click();
	     
	     driver.switchTo().defaultContent();
	    //switching to frame-3
	     
	     driver.switchTo().frame("classFrame");
	     
	     driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Overview']")).click();
                 
	     
	     
	}

}
