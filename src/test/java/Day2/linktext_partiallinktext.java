package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class linktext_partiallinktext {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
	     WebDriver driver = new ChromeDriver(chromeOption);
	     driver.get("https://www.amazon.in/");
		   driver.manage().window().maximize();
		   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirts");
		   driver.findElement(By.id("nav-search-submit-button")).click();
		   Thread.sleep(10000);
		 // driver.findElement(By.linkText("Men's T-shirt")).click();// link text 
		   driver.findElement(By.partialLinkText("Men's")).click();

	}

}
