package Day20FileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;





public class UploadFile_UsingRobotClass {

	public static void main(String[] args) throws  AWTException, InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		WebElement upload=driver.findElement(By.cssSelector("#file-upload"));
		Actions act=new Actions(driver);
		act.moveToElement(upload).click().perform();
		
       Robot rb= new Robot();
		rb.delay(1000);
		//put path of a file in clipboard
        String file ="C:\\Users\\arvind.sharma3\\Downloads\\Grid.pdf";
		StringSelection ss= new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		/*act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		act.sendKeys("Return");*/
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        



	}

}
