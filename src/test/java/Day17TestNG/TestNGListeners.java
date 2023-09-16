package Day17TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

/* TestNG Listeners- Sometimes when we write test cases and execute them , so some methods may
 pass some fail or skip, so based on the result of test cases we have to perform some
 post actions, so to perform these post actions we use listeners
 
Post actions- When we are done with execution of all test cases then we will generate 
the report, so report genertion is called post action.Post actions may be updating the updating the results
in the report, capturing the screenshots during failure.We can implement the post ACTIONS BY FOLlowing below 2:  
ItestListener- interface
testListenerAdapter - class which implements Itestlistener interface
Steps- 1. First create test case
2. Create a own listener class by extent testListenerAdapter or by implementing ItestListener.
3.This interface(ItestListener) or class(testListenerAdapter) contains certain methods:
onTestStart()- it will execute before every test
onTestFailure()- it will execute on failure of a teest
onTestSuccess()- it will execute on passing of a test
onTestSkipped()-  it will execute on skipping a test
onTestFinish()- it will execute after all test methods finish executing 
We will use these methods in our own listener class
4.Create an xml file which contains testcases and listener class entry   

   */

public class TestNGListeners 

{     @Test(priority=1)
     void test1()
     {
    	Assert.assertEquals(1, 1); 
     }
      
     @Test(priority=2)
        void test2()
      {
    	  Assert.assertEquals("A", "B");
      }
     
     
     @Test(priority=3, dependsOnMethods = "test2")
     void test3()
     {
    	 Assert.assertEquals(1, 1); 
     }
}
