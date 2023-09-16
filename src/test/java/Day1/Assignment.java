package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
	     WebDriver driver = new ChromeDriver(chromeOption);
	     driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
         driver.manage().window().maximize();
      WebElement email= driver.findElement(By.name("Email"));
      email.clear();
      email.sendKeys("admin@yourstore.com");
      WebElement pass= driver.findElement(By.name("Password"));
      pass.clear();
      pass.sendKeys("admin");
      driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
      String exp_title= "Dashboard";
      String actual_title = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();   
      System.out.println(actual_title); 
      if(exp_title.equals(actual_title))
       {
    	   System.out.println("Login is passed");
    	 
       }
       else 
      {  
    	   System.out.println("Login is failed");
       }
       driver.close();
}

	}


