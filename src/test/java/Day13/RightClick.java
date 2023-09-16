package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) 
	{
		 WebDriver driver= new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	       driver.manage().window().maximize();
	       
	       //For right click first we capture the element on which we right click
	       
	       WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
	       
	       // now using Actions class for right click
	       
	       Actions act=new Actions(driver);
	       act.contextClick(button).click().build().perform();  // contextClick means right click
	       
	       driver.findElement(By.xpath("//span[text()='Copy']")).click();
	       driver.switchTo().alert().accept();

	}

}
