package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Multiple_attributes {

	public static void main(String[] args)
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		/*if the locator is matching with multiple elements then we can use multiple 
attributes in the xpath to match with that particular element*/		

		//	driver.findElement(By.xpath("//input[@placeholder='Search store'][@class='search-box-text ui-autocomplete-input']")).sendKeys("apple");
		//the abpove xpath is also following "and" operator indirectly which means both attributes should be there  	
		/* we can use "and" or "or" operator in multiple attributes also */

		driver.findElement(By.xpath("//input[@placeholder='Search store'or @class='search-box-text ui-autocomplete-input']")).sendKeys("apple");
		driver.findElement(By.xpath("//input[@id='newsletter-email'and @class='newsletter-subscribe-text']")).sendKeys("arvind");	
		driver.findElement(By.xpath("//a[contains(text(),'Facebook') and @target='_blank']")).click();	

	}

}
