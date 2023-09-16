package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");
		WebElement firstbox=   driver.findElement(By.xpath("//input[@id='field1']"));
		firstbox.clear();
		firstbox.sendKeys("Hello admin");

		//capturing button for double click
		WebElement button= driver.findElement(By.xpath("//button[text()='Copy Text']"));

		//using Actions class for performing double click

		Actions act= new Actions(driver);
		act.doubleClick(button).build().perform();


		//Validating

//String value = driver.findElement(By.xpath("//input[@id='field2']")).getText();
/* this time it will not return the text because here we do not have any inner text but at run time value attribute
contains our own inserted text so we used that here
Note- getText()- it is used where we have inner text
      getattriubute- it is used where we do not have inner text and some attribute is containing our inserted text*/

		String value= driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");

		if(value.equals("Hello admin"))
		{
			System.out.println("test is passed");
		}






	}

}
