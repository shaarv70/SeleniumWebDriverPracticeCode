package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*Since we are using Actions in  different classes thats why we have to create 
//actions class object again and again, but on realtime we will create it one time
and perform all operations with that object only. */

public class DragAndDrop {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	       driver.manage().window().maximize();
	       
//For drag and drop first we have to capture source and target elements
	       
	     WebElement  source= driver.findElement(By.xpath("//div[@id='box6']"));
	     
	     WebElement target= driver.findElement(By.xpath("//div[@id='box106']"));
	     WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
	     WebElement southkorea=driver.findElement(By.xpath("//div[@id='box105']"));
	     
	     Actions act=new Actions(driver);
	     act.dragAndDrop(source, target).build().perform();
	     act.dragAndDrop(washington, southkorea).perform();// we can also write build
	     

	}

}
