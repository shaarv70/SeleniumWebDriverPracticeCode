package Day8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Dropdown not having select tag in DOM (input/div)-Bootstrap dropdown

public class HandleDropdownWithoutSelectTag {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3");
		driver.manage().window().maximize();

		//Clicking on the dropdown
		driver.findElement(By.xpath("//button[@type='button' and @class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> options= driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println(" The number of dropdown are :"+options.size());

		// printing all the options

		for (WebElement ele: options)
		{
			System.out.println(ele.getText());
		}

		// selecting a particular option

		for (WebElement ele1: options)
		{
			String text= ele1.getText();
			if(text.equals("Java")|| text.equals("Python"))
			{
				ele1.click();

			}


		}

	}

}
