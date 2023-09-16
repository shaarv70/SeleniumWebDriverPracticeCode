package Day14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions_2example {

	public static void main(String[] args) 
	{

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='target']"));

		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).perform();


	}

}
