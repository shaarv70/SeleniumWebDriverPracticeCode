package Day18PageObjectModel;

/*Page Object Model- 

In normal approach we are doing the duplications of methods in every class.
For Example- If we want to create test case for login, search and advanced search, we will make 3 classes for each testcase
in which in each class we have to write test case for login which means till advance search login method will be used 3 times
as advanced search  depends on search and search depends on login as well as if any updation comes in the future for login elements
then we have to update the elements of all methods of login of all classes.And also in this approach we will put the elemets and  
their cooresponding actions and validations in the same class.
 
So the normal approach has 2 disadvantages:
1) Duplication of elements and locators(As login method conatins elements/locators)
2) Updation

So in page object model what we do we: 
1)We analyse how many screens do we have in all test cases.
2)Write Page object classes which contains only elements and their corresponding actions.
3)In test methods we only put validations, and whenever required we will call the actions methods from Page Object Classes.

In short we will keep the elements and their corresponding actions in page object classes and invoke those classes
in test methods.

Page object model has 2 approaches to create page object classes:
1) Without using Page Factory(Normal approach)
2) Using Page Factory
*/

public class PageObjectModelIntro {

}
