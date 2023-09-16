package Day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		

		//Find total number of rows
		//Approach--1 - by using xpath 

		List<WebElement> rows=driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr"));
		System.out.println("Total numberv of rows are :"+ rows.size() );
		//Approach--2 - by using tagname(but it can be only used when there is only table having that tag)

		int size= driver.findElements(By.tagName("tr")).size();
		System.out.println(size);//it will give 8 because we have one more tr tag in some other table

		// Find total number of columns
		//Approach--1 - by using xpath 

		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("the number of column are: "+columns);
		//Approach--2 - by using tagname(but it can be only used when there is only table having that tag)
		int size_column= driver.findElements(By.tagName("th")).size();
		System.out.println(size_column);

		//Read specefic row and column data 
		String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]/td[1]")).getText();
		System.out.println(data);
		
		//Read data from all rows and columns
	/*	for (int i=1;i<=rows.size();i++)
		{   
			if(i<=1)
			{
			for(int j=1;j<=columns;j++)
				{
				   String value= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/th["+j+"]")).getText();
				    System.out.print("     "+value);
				}

			
			}
			
			if(i>1)
			{
				for(int j=1;j<=columns;j++)
			{
			   String value= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText();
			    System.out.print("    "+value);
			}

		}
		System.out.println(" ");	
		}*/

		
		// Print booknames whose author is amit
		
		for(int i=2;i<=rows.size();i++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[2]")).getText();
		    
			if(author.equals("Amit"))
			{
                    String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText();				
					System.out.print(author+"    "+bookname);
					System.out.println("");
			}
		}

		
		//Print sum of prices of all the books
		int sum=0;
		for(int i=2;i<=rows.size();i++)
		{
			
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			int pricing=Integer.parseInt(price);// change string to integer
			sum=sum+pricing;
		}

	        System.out.println(sum);
	}
}
