package Day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicTables {

	//Pagination table-- table present on multiple pages through which we can navigate

	public static void main(String[] args) throws InterruptedException 


	{
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement pass=driver.findElement(By.xpath("//input[@id='input-password']"));
		pass.clear();
		pass.sendKeys("demo");
		driver.findElement(By.tagName("button")).click();
		Boolean popup= driver.findElement(By.cssSelector("button.btn-close")).isDisplayed();
		if(popup.equals(true))
		{
			driver.findElement(By.cssSelector("button.btn-close")).click();
		}
		driver.findElement(By.xpath("(//ul[@id=\"menu\"]//li[@id=\"menu-customer\"]//a)[1]")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[1]")).click();

		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();  //Showing 91 to 100 of 5513 (552 Pages)

		// here substring will give the string starting from and ending to indexes(specified), then this substring will convert into integer

		System.out.println(text.indexOf("("));
		System.out.println(text.indexOf("Pages"));
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));


		System.out.println("Total number of pages:"+total_pages);

		for(int p=1;p<=10;p++)   //for(int p=1;p<=total_pages;p++)
		{
			if(total_pages>1)
			{
				WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']/li/*[text()="+p+"]"));	
				System.out.println(" Active Page : "+active_Page.getText());
                try {
				active_Page.click();
                }
                catch(ElementClickInterceptedException e)
                {    
                	WebElement active_Page_test=driver.findElement(By.xpath("//ul[@class='pagination']/li/*[text()="+p+"]"));
                	active_Page_test.click();
                }
                Thread.sleep(2000);
			}

			int noOfrows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println(" Total No Of Rows in active Page : "+noOfrows);

			for(int r=1;r<=noOfrows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String customerEmail=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();

				System.out.println(customerName+"      "+customerEmail+"          "+status);
			}

		}

		driver.quit();



	}

}
