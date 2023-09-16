package Day17TestNG;

/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/
//if all importing class are coming from a single library then we can also use *
import org.testng.annotations.*;


public class Annotations_Demo1 
{
     @BeforeMethod
	void login()
	{
		System.out.println("Login..");
	}
	
	@Test(priority=1)
	void search()
	{
		System.out.println("Search..");
	}
	
	@Test(priority=2)
	void advancedSearch()
	{
		System.out.println("advanced search..");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("Logout..");
	}
}
