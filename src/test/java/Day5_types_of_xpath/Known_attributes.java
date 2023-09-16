package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Known_attributes {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("tshirts");
       // driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Tshirts");
	    //  driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Tshirts");
	}
}

/* type is not widely used because in most of the 
cases it is not a unique element.It will match multiple elements.
tagname is optional or else we can write * in place of it */

