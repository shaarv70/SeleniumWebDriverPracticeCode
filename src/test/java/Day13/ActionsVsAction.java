package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

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
	       
/*Lets suppose we dont want to perform action immediately just want to create an action
and performing that action later on, so what we will do we will create that action and storing
it in a variable 
Actions- class (its functions is used to perform mouse actions)
Action- interface (its variable is used to store the action) 
*/
Action myaction= act.contextClick(button).click().build();// creating the action and storing it in a variable 
myaction.perform(); //performing that action aftersometime, so we can use in this way	 
	 
	       
	 driver.findElement(By.xpath("//span[text()='Copy']")).click();
	 driver.switchTo().alert().accept();

	}

}
