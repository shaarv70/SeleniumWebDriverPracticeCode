package Day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownWithHiddenOptions {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after']/i)[3]")).click();
		/* If we directly inspect dropdown we are not able to inspect the dropdown elements because on clicking they 
are visible but as we release out click they are hidden in DOM, so in order to handle them
we will go to event listeners and click on blur and click on remove and then click on dropdown options
this time we are able to inspect dropdown elements */

		List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));

		for(WebElement ele:options)
		{
			
			try
			{if(ele.getText().equals("Database Administrator"))
				ele.click();
			}
			catch(StaleElementReferenceException e)
			{
				List<WebElement> optionstest=driver.findElements(By.xpath("//div[@role='listbox']//span"));
				for(WebElement eletest:optionstest)
				{
					if(eletest.getText().equals("Database Administrator"))
						eletest.click();
				}
			}
			}





	}

}
