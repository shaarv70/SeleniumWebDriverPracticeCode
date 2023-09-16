 package Day10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args)
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		//capturing window ids
		
	Set<String> windowids=	driver.getWindowHandles();//store window ids 
	
	
/* we cannot retrieve elements from set as it doesnt work on index, so we
will convert it into List, then we can retrieve elements from the list


//Approach 1	
Note--- this approach is possible only when we have only 1 or 2 browser window
*/
 /*	List <String>windowid= new ArrayList(windowids);//converting Set--> List 
	String parentwindowid=windowid.get(0);
	String childwindowid= windowid.get(1);
	
	//switching driver from cuurent browser window to another browser window
	driver.switchTo().window(childwindowid);
	
	//performing action after switching driver
	driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
	
	//switching back to parent window id
	
	driver.switchTo().window(parentwindowid);
	driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
	
	
		*/
  //Approach--2 if we have more windows ids
	
/*	for(String winids:windowids) /* title is coming into picture because we dont know on which windowid driver 
                      is focused and which id is of which browser window so will check with title one  by one
 {
		String title=driver.switchTo().window(winids).getTitle();
		if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
		{
			driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		}
	}
	*/
	//closing specefic browser window based on choice
	
	for (String winids:windowids)
	{
		String title= driver.switchTo().window(winids).getTitle();
		if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")|| title.equals("OrangeHRM"))
{
	  driver.close();
}

	}

}}
