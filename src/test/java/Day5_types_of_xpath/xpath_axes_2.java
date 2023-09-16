package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_axes_2 {

	public static void main(String[] args) 
	{
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://www.facebook.com/reg/?rs=7");
	    driver.manage().window().maximize();
	    
	    //child
	    driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[11]/button")).click();

	    driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[11]/button/parent::div/preceding-sibling::div[10]/descendant::input")).sendKeys("arvind");
	}

}
