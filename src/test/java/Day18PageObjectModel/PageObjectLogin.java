package Day18PageObjectModel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//normal approach

public class PageObjectLogin 

{    WebDriver driver;
     WebDriverWait mywait;

PageObjectLogin(WebDriver driver)// constructor for initiating driver 
{
	this.driver=driver;
}

//capturing locators 
By username= By.xpath("//input[@placeholder='Username']");
By password= By.xpath("//input[@placeholder='Password']");
By login_btn=By.xpath("//button[normalize-space()='Login']");
By logo= By.xpath("//div[@class='orangehrm-login-branding']");


public boolean checkLogo()
{
	mywait= new WebDriverWait(driver, Duration.ofSeconds(40));
	 
	boolean logo_result=mywait.until(ExpectedConditions.visibilityOf(driver.findElement(logo))).isDisplayed();
    return logo_result;
}

public void setUsername(String name)
{
	driver.findElement(username).sendKeys(name);
}

public void setPassword( String pass)
{
	driver.findElement(password).sendKeys(pass);
}

public void clickBtn()
{
	driver.findElement(login_btn).click();
}


}
