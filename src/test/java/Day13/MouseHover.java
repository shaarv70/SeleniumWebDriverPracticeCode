package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args)
	{
       WebDriver driver= new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://demo.opencart.com/");
       driver.manage().window().maximize();
       
       //For mouse hover first we capture elements
       
           WebElement desktop=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
           WebElement mac= driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
           
           //For mouse actions we use Actions class
          /* Actions - class(provided by selenium webdriver)
             build()- it will create an action
             perform() - this will complete an action or perform an action. 
           */
           
           Actions act= new Actions(driver);  // here driver will be performing thats why put in bracket 
       
         act.moveToElement(desktop).moveToElement(mac).click().build().perform();//move to element will be called by act object not by driver
          //or we can also write 
           
     //  act.moveToElement(desktop).moveToElement(mac).click().perform();//this perform method will internally called build method then perform will execute
        
         
         
	}

}
