package Day18PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page Factory approach

public class PageObjectFactory 

{    WebDriver driver;
     WebDriverWait mywait;

PageObjectFactory(WebDriver driver)// constructor for initiating driver 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);// "this" is representing this class
}

//capturing locators (we can also use ang other locator(CSS , tagname, linktext etc.) other than xpath like (@FindBy(tagname=""))


@FindBy(xpath="//input[@placeholder='Username']")
WebElement username;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement password;

@FindBy(xpath="//button[normalize-space()='Login']")
WebElement login;

@FindBy(xpath="//div[@class='orangehrm-login-branding']")
WebElement logo;

//if we have number of webelements more then we can write in this way like we have to check the total number of links
@FindBy(tagName="a")
List<WebElement> links;

// one more approach for loacting the element
@FindBy(how=How.XPATH, using="//input[@placeholder='Username']")// here we can use other than XPATH also like CSS, tagnam,e
WebElement usernaming;


public boolean checkLogo()// since we have already captured the elements above so dont need to write whole statment 
{
	mywait= new WebDriverWait(driver, Duration.ofSeconds(40));
	 
	boolean logo_result=mywait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed();
    return logo_result;
}

public void setUsername(String name)
{
	username.sendKeys(name);
}

public void setPassword( String pass)
{
	password.sendKeys(pass);
}

public void clickBtn()
{
	login.click();
}


}
