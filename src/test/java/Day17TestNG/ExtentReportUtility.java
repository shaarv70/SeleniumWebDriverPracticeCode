package Day17TestNG;

/* ExtentSparkReporter,  ExtentReports, ExtentTest - these all 3 classes are provided by
ExtentReport */

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility implements ITestListener
{

	public ExtentSparkReporter sparkReporter;  // this object is reponsible for UI of the report(like color, theme etc.)
	public ExtentReports extent;  // this object is reponsible for populate common info on the report(like browser, suite, version, OS, who is executed, at what time)
	public ExtentTest test; //this object is reponsible for creating test case entries in the report and update status of the test methods(passed, failed or skipped data)

	public void onStart(ITestContext context) //this method will execute once before starting of all test so that empty report will be generated to enter info
	{
			
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");//specify location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Arvind");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
					
	}


	public void onTestSuccess(ITestResult result) //here the argument will get all the test methods
	{
		
		test = extent.createTest(result.getName()); // create a new enty in the report, result contains a test method and we are getting the name of that test method
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); //getThrowable() this will return the error message 
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
		
}
