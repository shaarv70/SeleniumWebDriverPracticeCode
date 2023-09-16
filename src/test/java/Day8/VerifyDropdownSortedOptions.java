package Day8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class VerifyDropdownSortedOptions {

	public static void main(String[] args) 
	{
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	List org= new ArrayList();
	List temp= new ArrayList();
	WebElement ele= driver.findElement(By.cssSelector("select#country"));
	Select drop= new Select(ele);
	List<WebElement> options= drop.getOptions();
	for(WebElement option:options)
	{
		org.add(option.getText());
		temp.add(option.getText());
	}
	//System.out.println(org);
    
	
	System.out.println("Before sorting "+temp);
	Collections.sort(temp);
	System.out.println("After sorting"+temp);
	
     
	if(org==temp)
	{
		System.out.println("Sorted dropdown");
	}
	else
	{
		System.out.println("Dropdown not sorted");
	}
	
	driver.close();
	
}}
