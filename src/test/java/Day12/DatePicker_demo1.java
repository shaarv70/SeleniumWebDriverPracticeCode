package Day12;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_demo1 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		//Approach1- by directly applying sendkeys- it can be only used where we are allowed to
		//enter input or we have input tag

		//	driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("11/23/2024");

		//Approach-2 we will handle calendar in same way as table   

		String year="2005";
		String month="March";
		String day="24";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//First we will capture month and year

		while(true)// here we are using while loop because we dont know how much we need to 
			// click on next button
		{
			String monthtest=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yeartest=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if(monthtest.equals(month) && yeartest.equals(year))
			{
				break;
			}
			// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//for future dates
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//for past dates
		}

		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for(WebElement datetest:dates)
		{
			String text=datetest.getText();
			if(text.equals(day))
			{
				datetest.click();
				break;
			}
		}




	}

}
