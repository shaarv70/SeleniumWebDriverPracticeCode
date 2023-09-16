 package Day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// frames inside a frame is called iframe
public class HandleFramesby_webelement_in_iframe {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		/*switching to frames through index or webelement--we use these 2
		 option if we dont have name or id attribute available 
		 */

		//switching to frame 1
		WebElement frm1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frm1);

		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Admin");

		// switching back to default to change the frame 
		driver.switchTo().defaultContent();

		//switching to frame 2 

		WebElement frm2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frm2);

		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Admin");

		//switching back to default

		driver.switchTo().defaultContent();

		//switching to frame 3 which is containing iframe

		WebElement frm3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));

		driver.switchTo().frame(frm3);

		//performing opeations in frame 3 textbox
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Admin");

		//switching from frame 3 to iframe(inside frame 3 )

		driver.switchTo().frame(0);/*here we are using index as only one frame is 
		                             present in frame 3 */

		//performing operations in iframe
		driver.findElement(By.cssSelector("div.AB7Lab")).click();
		
		List<WebElement> checkbox= driver.findElements(By.xpath("//div[@class='uHMk6b fsHoPb']"));
        for(WebElement check:checkbox)
        {
        	check.click();
        }
	    driver.findElement(By.xpath("//div[contains(@class,'e2CuFe')]")).click();
		List<WebElement> dropdown=driver.findElements(By.xpath("//div[contains(@class,'OA0qNb ')]//span"));
		System.out.println(dropdown.size());
  /*     for (int i=1; i<=dropdown.size();i++)
       {
    	   String text=dropdown.get(i).getText();
    	   System.out.println(text);
    	   if(text.equals("Well, now I know :-)"))
    	   {
    		   dropdown.get(i).click();
    		   break;
    	   }
       }*/
		for(WebElement option:dropdown)
		{        
			     String text=option.getText();
			     System.out.println(text);
                 if(text.equals("Well, now I know :-)"))
                 {   
                	 option.click();
                }
		}
    	   
       
        
        //switching back to default
        driver.switchTo().defaultContent();
        
        WebElement frm4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
	    driver.switchTo().frame(frm4);
	    
	    driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Admin");
	    
	    
	    
	    
	}

}
