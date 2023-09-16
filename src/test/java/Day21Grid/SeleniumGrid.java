package Day21Grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException 
	{   
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);//SSL certoificate
		String URL = "http://facebook.com";
		String Node = "http://localhost:4444"; 
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName","chrome");//This is deprecetaed after Selenium 4 
		//cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(Node), options);
		driver.get(URL);
		Thread.sleep(5000);
		driver.quit();

	}

}
