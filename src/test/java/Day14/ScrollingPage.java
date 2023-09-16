package Day14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//scroll button is not a webelement

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException 
	{
	   ChromeDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
	   
	   driver.manage().window().maximize();
	   JavascriptExecutor js= driver;
//---------------------------------------------------------	   
	   //scroll down by pixel
	//   js.executeScript("window.scrollBy(0,3000)","");
	    
//------------------------------------------------       
	   //return how much it scrolled
	//  System.out.println(js.executeScript("return window.pageYOffset;"));
	 //  in case of horizontal scrolling X will be replaced by "Y"
//--------------------------------------	  
	  //scroll down the page till the element is found
	  
	  WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
	  
	  js.executeScript("arguments[0].scrollIntoView();", flag);
	  System.out.println(js.executeScript("return window.pageYOffset;"));
//-----------------------------------------------------------
	  //scroll down till end of the document
	  
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  
	  System.out.println(js.executeScript("return window.pageYOffset;"));
//------------------------------------------------
	  Thread.sleep(3000);

	  // to go to initial position
	  js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	  
	}

}
