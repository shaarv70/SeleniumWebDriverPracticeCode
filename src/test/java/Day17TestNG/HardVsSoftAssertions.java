package Day17TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/* For hard assertions -when condition for hard assertions is checked and if it gets fail, after that no statement
 will be executed, so if we have more assertions after that assertion they will not be executed, so to overcome
 this we will use soft assertion  
 
 Hard assertion  are static methods directly available in assert class but soft assert are available in soft assert class
 but they are not static methods so we need to use object for using them
 
 Note- When all assertions are passed in a test method then it will be passed if one is failed then whole
 whiole test case if failed
 */

public class HardVsSoftAssertions
{
      @Test
	void test_hardassertion()
	{
		System.out.println("testing");
		System.out.println("testing");
		System.out.println("testing");
		System.out.println("testing");
	//	Assert.assertEquals(1, 1);//(1,1) means we are just giving equal values
	//	Assert.assertEquals(1, 2);
		System.out.println("Hard assertions completed");
         Assert.assertEquals(1, 1);	
	}

       @Test
      void test_softAssertion()
      {
    	  System.out.println("testing");
    	  System.out.println("testing");
    	  System.out.println("testing"); 
    	  System.out.println("testing");
    	  
    	  SoftAssert sa=new SoftAssert();
    	  sa.assertEquals(1, 1);
    	  System.out.println("Soft assertions completed");
    	  sa.assertEquals(1, 2);
    	  sa.assertAll();/* if we don not use this statement in soft assert then it 
    	                   will gives test case as passed although it is failed, so it is mandatory*/ 
      }    }
