package Day15;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Broken links 
When click on any link, it will send the request to the server and server will give the 
response to that click. So if we are getting any error in response from the server
then that link is called a broken link.

Prerequisites for a broken link
1) It must have a href attribute and href attribute must have a value, it should not be empty 
2) On returning the response it must return the error code (400,500,600 etc.)
 greater than >= 400
200 – valid Link
404 – Link Not Found
400 – Bad Request
401 – Unauthorized
500 – Internal error

Validation of the broken link

 So to send the request to server the link must be in URL format
 */

public class BrokenLinks {

	public static void main(String[] args) throws URISyntaxException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("total number of links are :"+links.size());

		int brokenlink=0;

		for(WebElement linkelement:links)
		{
			String targetlink= linkelement.getAttribute("href");
			//System.out.println(targetlink);


			//prerequisite for broken link 	
			if(targetlink ==null||targetlink.isEmpty())
			{
				System.out.println("href attribute value is empty");
				continue;   //it will go to next link 
			}

			URL linkurl= new URL(targetlink); //convert string --> url format for sending the request

			//sending request to server including 2 things - open connection,connect
			//linkurl.openConnection();
			/* this will open only connecion but not able to connect and the return type is URLConnection
 So to open and connect we will ujse https type */
			HttpURLConnection conn=(HttpURLConnection) linkurl.openConnection();
			//Since it is returnung URLconnection type so we are typecasting it to HttpsURLConnection type

			conn.connect(); //connecting with the server
			if(conn.getResponseCode()>=400)
			{
				System.out.println(targetlink+"     "+"----->Brokenlink");
				brokenlink++;
			}
			else System.out.println(targetlink+"      "+"------>not Broken link ");
		}
		System.out.println("total number of broken links are "+brokenlink);



	}

}
