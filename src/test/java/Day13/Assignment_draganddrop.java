package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment_draganddrop {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();

		WebElement bank=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement money=driver.findElement(By.linkText("5000"));
		WebElement sales=driver.findElement(By.xpath(" //a[normalize-space()='SALES'] "));
		Actions act= new Actions(driver);

   /*for(int i=1; i<=4;i++)
	       {   
	    	   WebElement space=driver.findElement(By.xpath("(//div//ol/li[@class='placeholder'])["+i+"]"));

	    	   if(i==1)
	    	   { Thread.sleep(2000);
	    		act.dragAndDrop(bank, space).perform();   
	    	   
	    	   }
               
	    	   if(i==2)
	    	   {Thread.sleep(2000);
	    		   act.dragAndDrop(money, space).perform();
	    	   }
	    	   if(i==3)
	    	   {Thread.sleep(2000);
	    		   act.dragAndDrop(sales, space).perform();

	    	   }

	    	   if(i==4)
	    	   {Thread.sleep(2000);
	    		   act.dragAndDrop(money, space).perform();
	    	   }
	       }*/

		WebElement space1=driver.findElement(By.xpath("(//ol/li[@class='placeholder'])[1]"));
		WebElement space2=driver.findElement(By.xpath("(//ol/li[@class='placeholder'])[2]"));
		WebElement space3=driver.findElement(By.xpath("(//ol/li[@class='placeholder'])[3]"));
		WebElement space4=driver.findElement(By.xpath("(//ol/li[@class='placeholder'])[4]"));
		act.dragAndDrop(bank, space1).build().perform();   
		act.dragAndDrop(money, space2).build().perform();
        Thread.sleep(4000);
		act.dragAndDrop(sales, space3).build().perform();
		act.dragAndDrop(money, space4).build().perform();

		String text=driver.findElement(By.xpath("//a[normalize-space()='Perfect!']")).getText();
		if(text.equals("Perfect!"))
		{
			System.out.println("testcase is passed");
		}
	}

}
