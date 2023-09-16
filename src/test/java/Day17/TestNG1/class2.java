package Day17.TestNG1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class class2

{   @Test
	void xyz()
	{
		System.out.println("this is xyz from class 2");
	}

@AfterTest
void n()
{
	System.out.println("After test method");
}
  @AfterSuite  
void as()
{
	System.out.println("After Suite");
}

}
