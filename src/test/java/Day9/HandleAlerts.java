package Day9;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Alert popup is not a webelement, it is an object thats why we cannot inspect it
 Alert with Ok
 Alert with Ok and cancel
 Alert with inputbox alongwith OK and cancel
 Alert with no element
 */

public class HandleAlerts {

	public static void main(String[] args) 

	{  /* FirefoxOptions option= new FirefoxOptions();
	    option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);*/
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait=  new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath(" //button[text()='Click for JS Alert']")).click();

		// switching our driver to alert popup screen
		String mess=driver.switchTo().alert().getText();
		System.out.println(mess);
		driver.switchTo().alert().accept();//- for clicking on ok

		//Alert is an interface not a class that why we are not writing like this 
		//Alert window=new Alert();-- many class are implementing alert*/
		Alert alertwindow=driver.switchTo().alert();//we can also write this, it will also return alert 
			alertwindow.accept();

			driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		// here we can also use explicit wait for alert popup screen

		Alert alertscreen=mywait.until(ExpectedConditions.alertIsPresent());// this will return alert 
		// for clicking on ok
		//	alertscreen.dismiss();// for clicking on cancel
		String text= alertscreen.getText();
		System.out.println(text);
		alertscreen.accept();
	}

	}
