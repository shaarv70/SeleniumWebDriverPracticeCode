package Day15;

import java.io.File;
import java.io.IOException;import java.nio.file.spi.FileTypeDetector;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*takescreenshotAS()  method is not only present in TakeScreenshot interface 
 but also present in WebElement class, so no need to use line 30 if we are capturing 
 screenshot of particular area, we can call takescreenshotAS() method from that 
 WebElement class object  */

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		//Cature full page screenshot --present in selenium 3 or 4 

	/*	TakesScreenshot ts= (TakesScreenshot) driver;//typecast

		File src=ts.getScreenshotAs(OutputType.FILE);//source file(it will give screenshot in file type)

		File trg= new File("C:\\Users\\arvind.sharma3\\Selenium-workspace\\SeleniumWebdriver\\screenshots\\fullpage.png");//target file(path of the file where screenshot must be kept & fullpage.png is file name not the folder)

		//copying screenshot file to folder file
		FileUtils.copyFile(src, trg);
		*/
		
		//capturing screenshot of specefic area of webpage-- present from selenium 4 onwards  
/* to take particular area screenshot first locate the whole area with suitable locator
 In this example we are capturing feature products area, so locating thw whole area with xpath
*/
		WebElement feature= driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src=feature.getScreenshotAs(OutputType.FILE);//callimg method from object of WebElement rest all steps are same as first scenario
		File target =new File("C:\\Users\\arvind.sharma3\\Selenium-workspace\\SeleniumWebdriver\\screenshots\\feature.png");
	    FileUtils.copyFile(src, target);
	    
	    //Capturing screenshot of single webelement(capturing logo in this example)
	    
	    WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	    File src1=logo.getScreenshotAs(OutputType.FILE);
	    File target1= new File("C:\\Users\\arvind.sharma3\\Selenium-workspace\\SeleniumWebdriver\\screenshots\\logo.png");
	    FileUtils.copyFile(src1, target1);
	
	}

}
