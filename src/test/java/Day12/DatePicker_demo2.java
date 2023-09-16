package Day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_demo2 {

	public static void main(String[] args) 

	{   
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy%20ticket%20for%20visa%20application/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='dob']")).click();
		WebElement yeartest=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		WebElement monthtest=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month=new Select(monthtest);
		Select year=new Select(yeartest);
		month.selectByVisibleText("Jan");
         try
         {
        	 year.selectByVisibleText("2022");
        	 
         }
         catch(StaleElementReferenceException e)
        
         {
        	 WebElement year_testing=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        	 Select year_test=new Select(year_testing);
        	 year_test.selectByVisibleText("2022");
        	 
         }
		
		List<WebElement> day=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for(WebElement daytest:day)
		{
			String text= daytest.getText();
			if(text.equals("30"))
			{
				daytest.click();
				break;
			}


		}







	}

}
