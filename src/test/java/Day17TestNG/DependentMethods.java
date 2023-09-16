package Day17TestNG;


import org.testng.Assert;
import org.testng.annotations.Test;

/* dependent method - By default TestNG executes all the methods whether some methods are dependents
 on some other methods, so if one method gets failed so all the dependent methods should also fail
 but still TestNG execute all those methods, so in order to overcome this, dependents methods are used 
 which will check if the method gets failed then the methods depends on it will not execute or they 
 will go in skip condition. 
 
 Scenario (realtime)-  if we do not apply dependent then what will happen if login methods gets failed
  so the methods dependent on login should also get fail or should not run as its like wasting of time ,
  but TestNG by default shows them passed or it will execute them because it has the behaviour of executing all the test methods.   
 
 */

public class DependentMethods 
{
    @Test(priority=1)
	void openApp()
	{
		Assert.assertTrue(true);/* What this will do it will pass the test because the argument sent as true
		                              its like a validation */ 
	}
    
    @Test(priority=2,dependsOnMethods= {"openApp"})// login method depends on open app method
    void login()
    {
    	Assert.assertTrue(false );
    }
    
    @Test(priority=3,dependsOnMethods = {"login"})// search method depends on login  method
    void search()
    {
    	Assert.assertTrue(true);
    }
    
    @Test(priority=4,dependsOnMethods = {"login","search"})
    void advancedSearch()
    {
    	Assert.assertTrue(true);
    }
    
    @Test(priority=5,dependsOnMethods = {"login"})
    void logout()
    {
    	Assert.assertTrue(true);
    }
    
}
