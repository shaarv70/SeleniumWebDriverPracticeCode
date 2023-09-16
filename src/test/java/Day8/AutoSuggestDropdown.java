package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@name='q' and @id='APjFqb']")).sendKeys("Selenium");
		/* for autodropdown inspect the dropdown and write xpath in such a way
that it can capture all dropdown elements together*/ 		
		Thread.sleep(3000);
		List<WebElement> dropdown= driver.findElements(By.xpath("//div[@class='wM6W7d'and @role='presentation']//span"));

		System.out.println("The number of elements in dropdown are "+dropdown.size());

		for (WebElement ele:dropdown)
		{
			String text=ele.getText();
			if(text.equals("selenium rich foods"))
				ele.click();
		}


	}

}
