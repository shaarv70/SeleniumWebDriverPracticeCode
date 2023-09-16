package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* close()- closing single browser window on which driver is focusing
   quit()- close all browsers window
 */

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//driver.close();
		/*now it will close only first window not the second as it focuses
		 on first window, to close all use quit()
		 */
		driver.quit();

	}

}
