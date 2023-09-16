package Day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/* to handle these kind of popup or alerts we need to pass username and pass
  alongwith URL   
syntax-- https://username:password@the-internet.herokuapp.com/basic_auth 
   */
public class AuthenticatedPopupOrAlert {

	public static void main(String[] args) 
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		String text= driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
		if(text.contains("Congratulations"))
		{
			System.out.println("test is passed");
			
		}
		else System.out.println("test is failed");
		
		
		

	}

}
