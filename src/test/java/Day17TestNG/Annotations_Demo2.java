package Day17TestNG;


import org.testng.annotations.*;

public class Annotations_Demo2 
{
	@BeforeClass
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
	
	@AfterClass
	void logout()
	{
		System.out.println("Logout..");
	}
}
