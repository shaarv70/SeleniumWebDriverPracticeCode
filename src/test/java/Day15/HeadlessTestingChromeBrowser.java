package Day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/* Headless testing- without UI we can execute testcases backend, browser will not launch here
Advantage- faster execution/performance is good
Disadvantage- 1)we cant explore the functionality/we cant see the actions/validations on UI
2) we cant capture screenshots also
When to prefer?
It will not prefer at beginning of testing, it is prefrred when testing activities are completed
or before releasing to the production, at the end of the testing 
*/

public class HeadlessTestingChromeBrowser {

	public static void main(String[] args) throws InterruptedException 
	{
        //Approach--1 applicable for all scenarios(traditional approach) 
		
		/*ChromeOptions Option=new ChromeOptions();// ChromeOptions--class
		Option.setHeadless(true);
/* so if we dont pass Options object as an argument to Chromedriver constructor still
 test case execute but ui will be visible so for headless testing we have to send Options
 as an argument to Chromedriver()   		
 */
		
/* Earlier we used to write 
 WebDriverManager.ChromeDriver().setup -- to setup the chromedriver then
 WebDriver driver = new ChromeDriver();
 So instead of writing above 2 steps for creating driver instance
 we can also write "WebDriver driver = WebDriverManager.chromedriver().create()"(here chromedriver is already
 created and returning driver & this create() method will  create driver instance.
 This possibility is there from Webdrivermanager 5.1 onwards. this will work in the same way
*/

//Approach -2 Webdriver manager 5.1++	
		ChromeOptions Option=new ChromeOptions();// ChromeOptions--class
	//	Option.setHeadless(true);
		Option.addArguments("--headless");
		
//so for headless testing we insert capabilities before create, so if we dont use capabilities option before create then normal UI execution starts 	
//WebDriver driver= WebDriverManager.chromedriver().capabilities(Option).create();
		
		WebDriver driver = new ChromeDriver(Option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	    Thread.sleep(10000);
		String actual_title = null;
		 try 
			{   
			actual_title = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(); 	
			}
			catch(NoSuchElementException e)
			{
				 actual_title = " ";
			}
			
		
	    String exp_title= "Dashboard";


	    
	    if (exp_title.equals(actual_title))	
		{
	    	        System.out.println("Login is successful");
	    		}
	    else 

	    {	System.out.println("Login is failed");

	    } 
	 

	}

}
