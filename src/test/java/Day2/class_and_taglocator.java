package Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class class_and_taglocator {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
	     WebDriver driver = new ChromeDriver(chromeOption);
	     driver.get("https://www.amazon.in/");
		   driver.manage().window().maximize();
		 //Find total number of slider
		   List<WebElement> slider= driver.findElements(By.className("a-carousel-card"));
		  System.out.println("the total numberof slider are "+slider.size());
		  
		  // total number of images in a screen
		  List<WebElement> images= driver.findElements(By.tagName("img"));
		  System.out.println("Total number of images"+images.size());
		  
		// total number of links in a screen
		  List<WebElement> links = driver.findElements(By.tagName("a"));
         System.out.println("Total number of links: "+ links.size());
	

	}

}
