package Day20SSL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//SSL-secured sockets layer(Protocol for web browsers and servers that allows for the authentication, encryption and decryption of data sent over the Internet.)

public class HandleSSLCertificate {

	public static void main(String[] args) 
	{   
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);//if we do not use this line then in outpur it will give privacy error in current title
		
		
	    WebDriver driver= new ChromeDriver(option);
	    driver.get("https://expired.badssl.com/");
	    driver.manage().window().maximize();
	    System.out.println(driver.getTitle());
	    driver.quit();

	}

}
