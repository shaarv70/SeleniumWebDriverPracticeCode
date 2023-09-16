package Day12;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {       //Assignment done by me 

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		WebElement depart=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departure=new Select(depart);
		departure.selectByVisibleText("Portland");
		WebElement dest=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destination=new Select(dest);
		destination.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		int columns=driver.findElements(By.tagName("th")).size(); 

		for(int i=1;i<=rows;i++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			float afterprice=Float.parseFloat(price.replace("$",""));
			float small= afterprice;
			
			int k=0;
			for(int j=2;j<=rows;j++)
			{   

				try
				{
					driver.findElement(By.xpath("//table[@class='table']//tr["+j+"]//td[6]")).getText();   
				}
				catch(NoSuchElementException e)
				{
					System.out.println("continue"); 
				}

				String pricetest=driver.findElement(By.xpath("//table[@class='table']//tr["+j+"]//td[6]")).getText();
				float smallprice=Float.parseFloat(pricetest.replace("$",""));
				if(small<smallprice)
				{
					small= small;
				}
				else
				{
					small=smallprice;
					k=j;
					}
}

			String aftersmall= "$"+small;
			System.out.println("The smallest price is "+aftersmall);
			int f=k;
			if(aftersmall.equals("$200.98"))
			{    

				try
				{driver.findElement(By.xpath("//table[@class='table']//tr["+f+"]//td[1]")).click();

				}
				catch(NoSuchElementException g)
				{
					driver.findElement(By.xpath("//table[@class='table']//tr["+f+"]//td[1]")).click();
				}

			}
			
			driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("ramesh");
			driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
			String title=driver.findElement(By.tagName("h1")).getText();
			if(title.equals("Thank you for your purchase today!"))
			{
				System.out.println("test case is passed");
			}
			break;
			}
			
			
		
	}}	


 







