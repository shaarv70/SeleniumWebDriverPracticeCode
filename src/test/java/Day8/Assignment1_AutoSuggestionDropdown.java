package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_AutoSuggestionDropdown {

	public static void main(String[] args) 
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("java");
		List<WebElement> dropdown= driver.findElements(By.xpath("//ul[@id='sa_ul']//li"));
		System.out.println("Number of elements in dropdown are :"+ dropdown.size());
        for (WebElement ele:dropdown)
        {
        	System.out.println(ele.getText());
        	if(ele.getText().equals("java compiler"))
        	{
        		ele.click();
        		break;
        		}
        }
	}

}
