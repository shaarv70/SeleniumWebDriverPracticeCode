package Day6;

import java.util.Set;

import org.apache.commons.math3.stat.inference.TTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* get(url)
   getTitle()
   getCurrentURL()-String
   getPageSource()- String   
   getWindowHandle()   String
   getWindowHandles()- Returns Set<String>
 We can use these methods with driver instance
 getText()- it is access from webelement, thats why they are not included here 
 */

public class GetMethod {

	public static void main(String[] args) throws InterruptedException 
	{
	    WebDriver driver= new ChromeDriver();
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    
	    String title=driver.getTitle();
	    System.out.println(title);
  	    
	    String url= driver.getCurrentUrl();
	    System.out.println(url);
	    
	    String pagesource= driver.getPageSource();
        boolean check=pagesource.contains("<link href=\"/web/dist/css/app.css?1672659722816\" rel=\"stylesheet\">");
	    
        System.out.println(check);
        
        String handle= driver.getWindowHandle();
        System.out.println(handle);
        
        Thread.sleep(3000);
        
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        
        
        Set<String> handles= driver.getWindowHandles();
        for (String window_handles:handles )
        { System.out.println(window_handles);
	    
	}

}}
