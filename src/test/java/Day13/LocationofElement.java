package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationofElement {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
	      
	       //on Default
	       System.out.println("Before maximising window"+logo.getLocation());
	       
	       //After maximising
	       driver.manage().window().maximize();
    
	      
	       System.out.println("After maximizing"+ logo.getLocation());
	       
	       //minimizing
	       driver.manage().window().minimize();
	       System.out.println("After minimizing"+logo.getLocation());
	       
	       //fullscreen(which means no browser tabs, no menus, no address bar)
	       driver.manage().window().fullscreen();
	       System.out.println("After full screen"+logo.getLocation());
	       
	       // setting the size of the window by ourselves
	       Point p= new Point(100,100);//point is a class
	       driver.manage().window().setPosition(p);// this will take arguments as point object(point object takes coordinates)
	       System.out.println("After setting window (100,100)"+logo.getLocation());
	
	}

}
