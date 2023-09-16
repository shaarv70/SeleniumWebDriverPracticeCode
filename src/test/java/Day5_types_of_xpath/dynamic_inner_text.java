package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dynamic_inner_text {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[contains(text(),' Digital')]")).click();
//it can be also written as 
		// driver.findElement(By.xpath("//a[contains(.,' Digital')]")).click();
	  
// -------------------------------------------------------------------------		
		//driver.findElement(By.xpath("//*[starts-with(text(),'Digital')]")).click();
		
}}
/* if the behaviour of an element is dynamic  or the partial text of the element is static 
 then we can use this contains() funtion in xpath. 
for example -- if a button on starting the script as start but after clicking over it 
it changes to stop, which shows the behaviour of the button is dynamic and the common 
static text in both the elememts is "st" 
tagname is optional or else we can write * in place of it
*/



/* if we want to locate the element with the first word of the inner text then we can 
use starts-with() function or if we want to locate the element by its last word
then we can use ends-with()function, but ends-with() function is deprecated
 after xpath 2.0, so we dont use it now  */
 