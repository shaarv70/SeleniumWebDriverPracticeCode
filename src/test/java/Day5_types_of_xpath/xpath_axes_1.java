package Day5_types_of_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_axes_1 {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();

			//self (Select current node)
		String self=  driver.findElement(By.xpath("//a[contains(text(),'Naturo Indiabull')]/self::a")).getText();
		System.out.println(self); 

		//parent (Select parent node of the current node(Only one))
		String parent= driver.findElement(By.xpath("//a[contains(text(),'Naturo Indiabull')]/parent::td")).getText();
		System.out.println(parent);

		//child (Select all children of current node(one or many))
		List<WebElement> childs= driver.findElements(By.xpath("//a[contains(text(),'Naturo Indiabull')]/ancestor::tr/child::*"));
		System.out.println("Number of child elements are "+ childs.size());

		//ancestor (Select all ancestor(parent or grandparent both)
		String ancestor= driver.findElement(By.xpath("//a[contains(text(),'Naturo Indiabull')]/ancestor::tr")).getText();
        System.out.println(ancestor);

        //descendant (it will include children and grandchildren both)
        List<WebElement> descendants=driver.findElements(By.xpath("//a[contains(text(),'Naturo Indiabull')]/ancestor::tr/descendant::*"));
        System.out.println("All desecendants are:"+ descendants.size());
		       
		//following (Select everything after closing tag of the current node)
		List<WebElement> following= driver.findElements(By.xpath("//a[contains(text(),'Naturo Indiabull')]/ancestor::tr/following::*"));
		System.out.println("The number of following nodes are "+ following.size());

		//following-sibling (multiple tags with same parent so the tags after self node are following-sibling tags)(bhai-bhn) 
		List<WebElement> followingsib= driver.findElements(By.xpath("//a[contains(text(),'Naturo Indiabull')]/parent::td/following-sibling::*"));
		System.out.println("The number of following siblings are : "+ followingsib.size());
         
		//preceding (Select all nodes that appear before current node )
		// (in preceding sibling counting starts from the node where we are starting from bottom to top)
		String preceding= driver.findElement(By.xpath("//a[contains(text(),'Naturo Indiabull')]/preceding::tr[2]/child::td/child::a")).getText();
		System.out.println(preceding);
		
		//preceding-sibling (multiple tags with same parent, the tags before self node are following-sibling tags)
		// (in preceding sibling counting starts from the node where we are starting from bottom to top)
		String precedingsib= driver.findElement(By.xpath("//a[contains(text(),'Naturo Indiabull')]/ancestor::tr/child::td[3]/preceding-sibling::td[1]")).getText();
		System.out.println(precedingsib);

         


	}

}
