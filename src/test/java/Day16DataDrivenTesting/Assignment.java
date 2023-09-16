package Day16DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Utility file- It is a .java file which contains some resuable methods for reading and writing data count rows, columns
 */


public class Assignment {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
        
		String file= System.getProperty("user.dir")+"\\testdata\\caldata2.xlsx";
		
		int rows= XLUtils.getRowCount(file,"Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			WebElement initial= driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		    WebElement time=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			WebElement rate= driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			
			
			String deposit= XLUtils.getCellData(file, "Sheet1", i,0 );	
			String length =XLUtils.getCellData(file, "Sheet1",i, 1);
			String interest=XLUtils.getCellData(file, "Sheet1",i, 2);
			String compound=XLUtils.getCellData(file, "Sheet1", i, 3);
			String total=XLUtils.getCellData(file, "Sheet1", i, 4);
			
			
			initial.clear();
			initial.sendKeys(deposit);
			time.clear();
			time.sendKeys(length);
			rate.clear();
			rate.sendKeys(interest);
			WebElement dropdown=driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", dropdown);
			
			
			List<WebElement> compounding= driver.findElements(By.xpath("//div[@role='listbox']//span"));
			
		for(WebElement option:compounding)
		{
			  String text= option.getText();
			  
			  if(text.equals(compound))
			  {
				  option.click();
			  }
        }
		
		WebElement button= driver.findElement(By.xpath("(//div[@class='mdc-button__ripple'])[8]"));
		js.executeScript("arguments[0].click()", button);
		
		
		String actual = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
		if(actual.equals(total))
        { 
		
			System.out.println("Passed");
			XLUtils.setCellData(file, "Sheet1",i,6,"Passed");
			XLUtils.fillGreenColor(file, "sheet1",i,6);
		}
		
		else
		{
			System.out.println("Failed");
			XLUtils.setCellData(file, "Sheet1",i, 6, "Failed");
			XLUtils.fillRedColor(file,"Sheet1", i, 6);
		}
			
		}



	}

}
