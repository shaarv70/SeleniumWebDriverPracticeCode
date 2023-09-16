package Day20FileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUpload_UsingSendkeys {

	public static void main(String[] args) throws InterruptedException 

	{
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\arvind.sharma3\\Desktop\\Idea.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        String exp="File Uploaded!";
        Thread.sleep(3000);
        String actual=driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).getText();
        if(exp.equals(actual))
        {
        	System.out.println("Test is passed");
        }
	    
        driver.close();
	
	}

}
