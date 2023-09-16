package Day10;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("Selenium");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
		driver.findElement(By.linkText("Selenium")).click();

		List<WebElement> links= driver.findElements(By.xpath("//div[@id=\"Wikipedia1_wikipedia-search-results\"]//a"));
		for(WebElement link:links)
		{
			String text= link.getText();
			System.out.println(text);
			link.click();
		}
        Set<String> windids=driver.getWindowHandles();
		
        for(String id:windids)

		{ String title= driver.switchTo().window(id).getTitle();
		  System.out.println(title);
			
		}
        driver.quit();
	}

}
