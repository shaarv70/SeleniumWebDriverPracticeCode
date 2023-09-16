package Day14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsandWindows {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
 // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//this will open in same browser tab
  
  
  
  //so to open second application in another tab we can do
  
//  driver.switchTo().newWindow(WindowType.TAB);//opens new tab
 // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  
  //to open new browser window
  
  driver.switchTo().newWindow(WindowType.WINDOW);//open new browser window
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  Set<String> handles=driver.getWindowHandles();
  
  List<String> winids=new ArrayList(handles);
  
  for(String id:winids)
  {
	 String title=driver.switchTo().window(id).getTitle();
	 
	 if(title.equals("Your Store"))
	 {
		 driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("tshirt");
	 }
			 
	  
  }
   


	}

}
