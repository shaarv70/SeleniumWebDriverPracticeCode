package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//select[@id='country-list']")).click();
		List <WebElement> option=driver.findElements(By.xpath("//select[@id='country-list']//option"));
        
		
		for(WebElement ele:option)
        {
        	String text=ele.getText();
        	if(text.equals("France"))
        	{
        		ele.click();
        	}
        }
		
		 driver.findElement(By.xpath("//select[@id='state-list']")).click();
		 Thread.sleep(10000);
		 List <WebElement> state= driver.findElements(By.xpath("//select[@id='state-list']//option"));
		 for(WebElement sta:state)
		 {   String text= sta.getText();
		    if(text.equals("Ile-de-France"))
		    sta.click();
			 
		 }
	}

}
