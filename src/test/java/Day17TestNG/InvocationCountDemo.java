package Day17TestNG;

import org.testng.annotations.Test;

/* InvocationCount- Need?
 Sometimes we have to check one functionality again and again, maybe it conatins some loopholes
 which cannot be detected by executing the testcase one time or 2 times, so in that case
 we will use invocation count in which we will execute the particular test method
as many times as we need. This type of testing we also called as Exhaustive testing.
Advantage- We can execute test case as many times without any loop. 
 */

public class InvocationCountDemo
{
    @Test (invocationCount=10,timeOut = 6000)
	void test()
	{
		System.out.println("testing...");
	}
}
