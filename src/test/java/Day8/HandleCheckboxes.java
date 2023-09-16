package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		//Select specefic one checkbox
		//	driver.findElement(By.xpath("//input[@id='monday']")).click();

		//total number of checkboxes
		List<WebElement> number= driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Number of checkboxes "+ number.size());

		//Select all checkboxes

		/*	     for (int i=0; i<number.size();i++)
        {
        	     number.get(i).click();
        }*/


		/*   for (WebElement ele:number)
             {
            	 ele.click();
             }*/

		//Select last 2 checkboxes formula -total checkbox - how many checkbox u want to select = starting index

		/*	for (int i=number.size()-1;i>=5;i--)--my own way
		{

			number.get(i).click();
		}*/

		/*	for (int i=5; i<=number.size(); i++)- pavan way
		{  
			number.get(i).click();
		}*/

		//Select first 2 checkbox

		/*	for (int i=0;i<=1;i++)
		{
			number.get(i).click();
		}*/

		//Already selected and now unchecked

		/*    for (int i=0; i<number.size();i++)
		     {
		    	 if(number.get(i).isSelected())
		    	 { number.get(i).click();
		     }*/

		for (int i=0; i<3;i++)
		{
			number.get(i).click();
		}

		Thread.sleep(1000);
		for (WebElement ele:number)
		{
			if(ele.isSelected())
				ele.click();
		}





	}}
