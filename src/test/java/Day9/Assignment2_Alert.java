package Day9;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment2_Alert {

	public static void main(String[] args)
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	Alert alertscreen=mywait.until(ExpectedConditions.alertIsPresent());
	String text=alertscreen.getText();
	System.out.println(text);
	alertscreen.accept();

	}

}
