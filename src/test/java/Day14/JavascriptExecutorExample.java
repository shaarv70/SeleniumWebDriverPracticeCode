package Day14;
/* JavaScriptExecutor- interface
executeScript()- with this method we can execute javascript statements in selenium

why we use javascript statments in selenium?

Scenario: Normally in identifying an element lets uppose we want to input a value in textbox 
which we will do with sendkeys method but actually what is happening our sendkeys method
cannot interact with the  element directly, so we can say in this way

 sendkeys(arguments)
 {
 javascript statments
 }
so when we are calling sendkeys method the javascript statments present inside the sendkeys 
method will interact with the element, but actually what is the code inside the sendkeys method 
and how it is interacting we dont know 
In some applications sendkeys or click directly wont work we may get element intercepted exception
in these cases whichever method we are using correspondely method should be called but when 
we are calling this method there is some delay its not immediatley called even if our locator is correct 
or method is correct so we are not able to interact thats why got this exception.

So instead of calling sendkey by passing data  javascript will directly exceute by 
executeScript() method, this is coming from JavaScriptExecutor.We are just bypassing the 
selenium command, this executeScript() will directlty interacting with the element.
 
 Another answer-----
 JavaScript executor is an interface which contains executorScript method and by using this method we can execute Javascript method in selenium
 needed? --sometimes webdriver method may not be able to interact with the elements because of the delay, 
 so instead we execute javascript statements with executorScript() method to perform different actions.
*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorExample {

	public static void main(String[] args) 
	{
	//	WebDriver driver= new ChromeDriver();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-one1434677811");
	
//We will ujse javascript executor in that case where sendkeys or click like these metjods wont work	
		JavascriptExecutor js= (JavascriptExecutor)driver;//typecasting
	//	JavascriptExecutor js= driver;// no need to typecast as chromedriver is a child of Javascriptexecutor interface
		
		//inputbox
		WebElement input=driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']"));
		
		js.executeScript("arguments[0].setAttribute('value','john')", input);
		
		//Radiobutton
		WebElement radiobutton=driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']"));
		
		js.executeScript("arguments[0].click()",radiobutton);
		
		//Checkbox
		
		WebElement checkbox= driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_0']"));
		js.executeScript("arguments[0].click()", checkbox);
		
		//button
		WebElement button= driver.findElement(By.xpath("//input[@name='Submit']"));
		js.executeScript("arguments[0].click()", button);
		
		
		
	    

	}

}
