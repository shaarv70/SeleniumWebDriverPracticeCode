package Day17TestNG;

import org.testng.annotations.Test;

/* we cannot execute java methods in TestNG classes because we dont have main method
 in TestNG class and witjhout annotation we cant use test methods in TestNG class 
 */

public class FirstTest {
	
	
	@Test// this annotation will imply this is TestNG method & Run|Debug or Run All - links (they are only present when test methods are present in class)  
	void test1()
	{
		System.out.println("testing1");
	}
     
	@Test	
	void test2()
	{
		System.out.println("testing2");
	}
	
	@Test
	void test3()
	{
		System.out.println("testing3");
	}
 
  
}
