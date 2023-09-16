package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownsSelectTag {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		WebElement drpCountryEle= driver.findElement(By.xpath("//select[@id='country-list']"));
		
		//For dropdown we use Select class
		
		Select drpcountry= new Select(drpCountryEle);
		//Select - class
		
		//Selecting an option from dropdown
		
		//drpcountry.selectByVisibleText("France");
		//drpcountry.selectByValue("2");// value means the value attribute value & visible text and value is not same
		//if in case visible text is not present and only value attribute is present
		
		drpcountry.selectByIndex(4);
		
		// Find total options in dropdown
		 List<WebElement> options=drpcountry.getOptions();
		 System.out.println("the number of options are : "+ options.size());
		 
		 //print options in console window 
		 for (WebElement option: options)
		 {
			 System.out.println(option.getText());
		 }
		


	}

}
