package Day19Download_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFiles_UsingFirefox {

	public static void main(String[] args) 
	{
	   WebDriver driver=new ChromeDriver();
	   driver.get("https://demo.automationtesting.in/FileDownload.html");
	   driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("my testing data");
	   driver.findElement(By.xpath("//button[@id='createTxt']")).click();
	   driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
	   
	   
	   driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("testing is good");
	   driver.findElement(By.xpath("//button[@id='createPdf']")).click();
	   driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();

	}

}
