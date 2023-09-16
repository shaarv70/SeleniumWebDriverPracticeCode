package Day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderElement {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
	       driver.manage().window().maximize();
	       
/*First capturing the location of the element(these locations will be different based 
 on the size of the screen 
 Note- it is better to maximise the page before validating the element*/
	       
	       
	       WebElement leftslider= driver.findElement(By.xpath("//span[1]"));
	       System.out.println("Initial position"+ leftslider.getLocation());
	       
	      //changing slider position with actions class
	       
	       Actions act=new Actions(driver);
	       
	       act.dragAndDropBy(leftslider,100, 249).perform();
	       
	       System.out.println("After sliding position"+ leftslider.getLocation());
	       
	       WebElement rightslider=driver.findElement(By.xpath("//span[2]"));
	       System.out.println("Initial position"+rightslider.getLocation());
	       
	       
	      act.dragAndDropBy(rightslider,-100 , 249).perform();
	      System.out.println("Final sliding position"+rightslider.getLocation());
	       
	

	}

}
