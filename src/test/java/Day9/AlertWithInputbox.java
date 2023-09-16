package Day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWithInputbox {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait=  new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(" //button[text()='Click for JS Prompt']")).click();
		driver.switchTo().alert().sendKeys("Admin");
		driver.switchTo().alert().dismiss();
		
	    String text= driver.findElement(By.xpath("//p[@id='result']")).getText();
	    String exp_text= "You entered: Admin";
	    if(text.equals(exp_text))
	    	System.out.println("test is passed");
	    else 
	    	System.out.println("test is failed");
	    

	}

}
