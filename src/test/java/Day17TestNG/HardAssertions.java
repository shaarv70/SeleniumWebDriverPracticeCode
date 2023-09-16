package Day17TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

/* Assertions:They are the alternative to if-else conditions but they are preffered to use.
 Scenario-- For example we have used if-else condition in our method and given the condition as
 if - if condition is passed then print passed and if -if condition gets fail then print failed
 so whjen TestNG executes the method and lets suppose if condition gets fail so it will print "Test case is failed"
 but in TestNG execution summary that test method is showing passed because here the method is compoletely executed 
 but here since out testmethod result is failed so TestNG should also give the testmethod as failed but it is showing
  passed(so we can say here if-else is not impacting the output of our test method thats why 
  TestNG is showing the result as Passed), so in order to overcome this problem we use Assertions. 
 
 Hard assertions- Assertions coming from assert class 
 
 */
public class HardAssertions

{    @SuppressWarnings("unused")
@Test
	void check()
{

	int x=10;
	int y=17;

	/*if(x==y)
	{
		System.out.println("test is passed");

	}

	else
	{
		System.out.println("test is failed");
	}  this scenario will give the output as test is failed but TestNG gives Passed */

	//	Assert.assertEquals(x, y);// it will compare bowht values and its result
	//will impact the whole testcase result(TestNG result)

	//	Assert.assertTrue(true);//pass
	//Assert.assertTrue(false);//fail-zabardasti fail krvaana ho to


	//Assert.assertEquals(actual, expected,description);description will show only when actual condition gets fail
	//Assert.assertEquals(x>y,true,"x is not greater than y");
	
	
	String s1="abc";
	String s2="xyz";
	
	Assert.assertEquals(s1,s2,"strings are not equal");//fail
    Assert.assertNotEquals(s1, s2);//pass
    
    
    if(true)
    {
    	Assert.assertTrue(true);
    	
    }
    
    else
    {
    	Assert.assertFalse(false);
         Assert.fail();//we can write this if we dont want confusion    
    
    }
}
}
