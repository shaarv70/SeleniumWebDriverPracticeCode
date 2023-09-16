package Day19Download_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/*In case of firefox it gives one popup before downloading so to handle that popup we need to write vertain
 statements 
 */

public class DownloadFiles_UsingChrome {

	public static void main(String[] args) 
	{
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");//MIME Type
/*MIME TYPE MEANS  we are informing firefox that we are saving this type of file, we have fifferent types of 
 MIME type we can refer:https://www.sitepoint.com/mime-types-complete-list/
 Note : If we have different types of file then we just need to separate mime by commas as mentioned above */		
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);//only for pdf file
		FirefoxOptions option= new FirefoxOptions();
		option.setProfile(profile);
		
	   WebDriver driver=new FirefoxDriver(option);
	   
	   driver.get("https://demo.automationtesting.in/FileDownload.html");
	   driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("my testing data");
	   driver.findElement(By.xpath("//button[@id='createTxt']")).click();
	   driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
	   
	   
	   driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("testing is good");
	   driver.findElement(By.xpath("//button[@id='createPdf']")).click();
	   driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();

	}

}
