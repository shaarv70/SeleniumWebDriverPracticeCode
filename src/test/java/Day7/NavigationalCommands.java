package Day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/* 
 navigate().to()- it is exactly same as driver.get()-but here url must be in string
 but in navigate().to(url)- it can accept in 2 formats (URL or string),
 as it is internally calling get() method
 Actual working--------At first if we are passing the URL in URL format  
 then the if condition check whether it is in String or URL format then it will convert it to 
 String first and then pass to .get("url")  
 navigate().to(url)
 {    if()
     driver.get("url");
 }
 URL myurl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
 here the string URL is converted to normal URL
 
 navigate - return the navigation type and inside this navigation class object to() method 
 is present
 
 
 
 navigate().forward()
 navigate().back()
 navigate().refresh()
*/

public class NavigationalCommands {

	public static void main(String[] args) 
	{
	     WebDriver driver = new ChromeDriver();
	     
	     driver.navigate().to("https://www.amazon.in/");
	     System.out.println(driver.getCurrentUrl());
	     driver.navigate().to("https://www.flipkart.com/");
	     System.out.println(driver.getCurrentUrl());
	     driver.navigate().back();
	     System.out.println(driver.getCurrentUrl());
	     driver.navigate().forward();
	     System.out.println(driver.getCurrentUrl());
	     driver.navigate().refresh();
	     
	     
	     

	}

}
