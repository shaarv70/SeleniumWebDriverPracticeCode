package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class tag_and_attribute {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("apple");
		driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	}

}
