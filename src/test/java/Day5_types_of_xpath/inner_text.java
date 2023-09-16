package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class inner_text {

	public static void main(String[] args) 
	{

		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	//	driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		
/* In this case inner text is same as link text but in case of link
 text there should be an anchor <a tag, but text() function in xpath can be used
 everywhere  where we have inner text
 tagname is optional or else we can write * in place of it 		
*/   
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("apple");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
	}

}
