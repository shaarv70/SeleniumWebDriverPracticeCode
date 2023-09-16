package Day17TestNG;

import org.testng.annotations.Test;

/* In realtime we have to execute different types of testcases which comes under different 
 groups like regression, sanity, functional, end to end, so we will divide the test cases based on 
 the groups.
 Whenever grouping is done, these test cases will be executed by xml file only in which we will use
 group tag, run tag and include and exclude tag 
 We can add n number of classes in xml file in which we need to apply grouping concept
 Normally we create a separate xml file grouping for executing test cases by groups.
 And for executing all test cases a master xml file 
 
Example:-
loginByEmail  - sanity & regression
loginByfacebook - sanity
loginBytwitter  - sanity

signupbyemail - sanity & regression
signupbyfacebook  - regression
signupbytwitter  - regression

paymentinrupees - sanity & regression
paymentindollar - sanity  
paymentReturnbyBank  - regression

So if we want to execute only sanity test, regression test then we use include tag only 
but if we want to execute only sanity but not regression then we use exclude tag 

 */
public class Grouping 
{

	@Test(priority=1,groups= {"sanity","regression"})
	void loginByEmail()
	{
		System.out.println(" this is login by email");
	}
	
	@Test(priority=2,groups= {"sanity"})
	void loginByfacebook()
	{
		System.out.println(" this is login by facebook");
			
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginBytwitter()
	{
		System.out.println(" this is login by twitter");
	}
	
	
	@Test(priority=4,groups= {"sanity","regression"})
	void signupbyemail()
	{
		System.out.println("signup by email");
	}
	
	@Test(priority=5,groups= {"regression"})
	void signupbyfacebook()
	{
		System.out.println("signup by facebook");
	}
	
	@Test(priority=6,groups= {"regression"})
	void signupbytwitter()
	{
		System.out.println("signup by twitter");
	}
	
	@Test(priority=7, groups= {"sanity"})
	void paymentindollar()
	{
		System.out.println("this is payement by dollar method");
	}
	
	@Test(priority=8,groups= {"sanity","regression"})
	void paymentinrupees()
	{
		System.out.println("this is payement by rupees method");
	}
	
	@Test(priority=9,groups= {"regression"})
	void paymentReturnbyBank()
	{
		System.out.println("payment return by bank");
	}
	
	
	
	
	
	

}
