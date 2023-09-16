package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class visible_text {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//if visible text is present like in search textbox "Search store " is written
		
		driver.findElement(By.xpath("//input[@placeholder='Search store']")).sendKeys("apple");
		

	}

}
