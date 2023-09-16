package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Conditional methods-  these are only be accesed with webelement & return boolean value
   isDisplayed()
   isEnabled()
   isSelected()
 */      


public class ConditionalMethods {

	public static void main(String[] args)
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		//logo status (isDisplayed())
		Boolean check=driver.findElement(By.cssSelector("[alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(check);

		//search box (isEnabled())
		Boolean check1= driver.findElement(By.cssSelector("input.search-box-text")).isEnabled();
		System.out.println(check1);

		//radiobutton (isSelected())
		Boolean t= true;
		Boolean f=false;
		driver.findElement(By.linkText("Register")).click();
		Boolean male=driver.findElement(By.xpath("//input[@id='gender-male']")).isDisplayed();
		if(male.equals(t))
		{  Boolean select= driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		if(select.equals(f))
		{ driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		Boolean latest = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		System.out.println(latest);
		}

		}
		else 
			System.out.println("The radiobutton is displayed or not "+male);


	}

}
