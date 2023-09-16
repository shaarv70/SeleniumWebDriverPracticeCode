package Day17TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/* Here we will overriding the methods of interface*/

public class MyListenerClass implements ITestListener

{

	public void onTestStart(ITestResult result) 
	{
		System.out.println("On Test Started from listener");
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("On Test passed from listener");
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("on Test Failed from listener");
	}

	public void onTestSkipped(ITestResult result) 

	{
		System.out.println("On test skipped from listener");
	}

	public void onFinish(ITestContext context) 

	{
		System.out.println("On test finished from listener");

	}


}
