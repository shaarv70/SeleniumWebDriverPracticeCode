package Day17.TestNG1;


import org.testng.annotations.*;

public class class1 
{
    
	@Test
	void abc()
    {
    	System.out.println("abc from class1");
    }

	@BeforeTest
    void m()
    {
    	System.out.println("Before test");
    }
	
	@BeforeSuite
	void bs()
	{
		System.out.println("Before suit");
	}

	@BeforeClass
	void bc()
	{
		System.out.println("from before class");
	}
	
	@AfterClass
	void ac()
	{
		System.out.println("From after class");
	}
}
