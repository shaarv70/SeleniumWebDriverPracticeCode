package Day17TestNG;

/*TestNG - It is a built in framework, Junit is also a built in framework, cucumber is also a built i framework
Steps for installation- 1) download testNG from eclipsemarket place
 2) Help > Install new Software > ADD > name & add version linkhttps://testng.org/testng-eclipse-update-site/" >ok 
3) Windows > preferences >testNG should be in the list  
 TestNG - it stands for Test New Generation. It is a java based unit testing tool.
 Advantages- 1. Managing test cases and test suites
 2.Grouping of test cases
 3.Prioritize
 4.Parameterization - We can pass parameters to test case like running on different browser,running on different verion or Data driven testing
 5.Parallel testing - Running test case on  multiple browser
 6. Reports- we can generate TestNG reports(but in realtime extent reports are used)
 
 All these above points are achieved by XML File
 XML file- a. Create manually-1)Right click on the package--> file--> filename.xml-->First two statements are compulsory, that we
   will copy from some other file
   2) Then write the tags and attributes
           b. Generate Automatically - 1)Right click on test case you want to convert-->TestNG-->
           convert to TestNG--> click on browser for creating in same package-->Go to project
           -->go to that particular package.
           3. in XMl file you can also add multiple test cases of class tag
           4. then run it 
           5. Then refresh the Project one folder name as output will be made, in that we have two file one is
           emailable and one is index we can open either of them
           
 We prefer making xml file manually, we need to add few more tags which are not present in automatic method          
 
Prerequisites-  1.First we need to add dependency TestNG in pom.xml file so that if we run our project outside Eclipse like in GIt jenkins- then we can run
2. Then we need to add plugin from eclipse marketplace,then after installing go to install new software
-->click on add-->write TestNG and in below bbox we need to add TestNG url from this url 
https://testng.org/testng-eclipse-update-site/  - copy any of the version 
3.then go to windows--> prefernces--> then you will get name in the list as TestNG      
4. Right click on project -->properties-->java build path- Library -->add library-->testNG--Apply & close  
normal approach - TestSuite-->Test cases-->test steps
testNG appraoch -  Package/XML--> classes--> Test methods or Suite/XML-->test(multiple)-->classes(multiple)-->methods(multiple)

Note -1)In testNG we dont use main method()
2) Here by default test methods are executed in alphabetical order, so to customize our order
we use priority

Annotations:

@test - it represent test method which executes in TestNG class

@BeforeMethod- it will execute everytime before starting execution of a test method
@AfterMethod-  it will execute everytime after completing execution of a test method

@BeforeClass- it will execute once before starting execution of a class(collection of methods)
@AfterClass- it will execute once after completing execution of a class(collection of methods)

@BeforeTest-it will execute everytime before starting execution of a test(collection of classes)
@AfterTest- it will execute everytime after completing execution of a test(collection of classes)

@BeforeSuite-it will execute once before starting execution of a suite(collection of test)
@AfterSuite- it will execute once after completing execution of a suite(collection of test)

After mentioning these annotations we can write method anywhere we want in class
 
 

 
 */





public class TestNG_Introduction 
{

}
