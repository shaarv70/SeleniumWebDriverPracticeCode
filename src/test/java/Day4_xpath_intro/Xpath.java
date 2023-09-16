package Day4_xpath_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath {

	public static void main(String[] args)
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		String product_name = driver.findElement(By.xpath("//a[text()='Apple MacBook Pro 13-inch']")).getText();
		System.out.println(product_name);
	}
}

//xpath having multiple attributes
// xpath functions- text(), normalized-space(),starts-with(),ends-with() etc
//xpath operators - and , or
//xpath axes -- self, following, preceding, ancestor, parent, sibling etc. 
