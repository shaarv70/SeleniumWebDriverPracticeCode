package Day5_types_of_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class multiple_elements {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOption= new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://demo.nopcommerce.com/");
		String text = driver.findElement(By.xpath("/html/body/div[6]/div[last()]/div[1]/div[last()]/div[1]/div[1]/strong")).getText();
        System.out.println(text);
	}

}

/* For multiple elements we can use last() function if we have
last element as matching element, or we can use index for loacting elements in
DOM, index starts from 1 */