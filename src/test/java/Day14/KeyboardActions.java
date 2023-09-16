package Day14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hello I am test" );

		Actions act=new Actions(driver);

		//Ctrl+a

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

		//ctrl+c

		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

		//if we want to press  single key
		//  Approach--1
		//Tab
	//	act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		//Approach--2

		act.sendKeys(Keys.TAB);
		//Ctrl+v

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		//spacebar
		act.sendKeys(Keys.SPACE).perform();

	}

}
