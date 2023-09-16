package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSS_locator {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
	     WebDriver driver = new ChromeDriver(chromeOption);
	     driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			
			// in all below syntax tag is optional
			
			//tag id   #
			//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Tshirts");
			//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Tshirts");
			
			//tag class   . 
			//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Tshirts");
			//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Tshirts");

			//tag attribute    []

			// driver.findElement(By.cssSelector("input[aria-label='Search store']")).sendKeys("tshirts");
			 //driver.findElement(By.cssSelector("[aria-label='Search store']")).sendKeys("tshirts");   
		    
			//tag class attribute    .  []
			 //driver.findElement(By.cssSelector("input.search-box-text[aria-label='Search store\']")).sendKeys("tshirts");
			
			//nth element in CSS selector
			//cssselector:nth-child(n)
			 driver.findElement(By.cssSelector(".search-box-text[aria-label='Search store\']")).sendKeys("tshirts");
			// driver.close();
     
			 }

}
