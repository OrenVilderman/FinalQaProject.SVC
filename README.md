This project is the Final project of the SVCollege Automation-Course.
=============
Created by [Oren Vilderman](https://www.linkedin.com/in/oren-vilderman-5208a8171/)<br/>
> The purpose of this project is to present my knowledge in Java and in QA methodology

**In this project there are STDs, Tests, and bug reports, more details about the project and the purpose of this project can be found on the included STP,**<br/>**All files are in the project folders under the: "FinalProject.SVC" folder.**<br/><br/>**Tests performed by default on the site [SVCollege Test Site](https://svcollegetest.000webhostapp.com/),**<br/>**But alternative local versions of the site are included in the "SVC final project files" folder (To run the test on the local files, read lines 24-28 in "MethodsManager.java").**<br/><br/>**The tests are written in Java, using Selenium WebDriver and implementing the "Page Object Model" design pattern.**<br/><br/>**The tests are:**<br/><br/>
1) Sanity - The test include 164 tests and returns - 14 - Failures  

2) Functionality - The test include 34 function tests: 
-	For	Function: Long word Question: returns - 3 - Failures
-	For	Function: Multi words Question:	returns - 3 - Failures
-	For	Function: Space as Question: returns - 1 - Failure
-	For	Function: Continue without Question:
-	For	Function: Hebrew text Question:
-	For	Function: Number as Question:
-	For	Function: Singe as Question:
-	For	Function: Question mark as Question: returns - 1 - Failure
-	For	Function: Back button (In Question creation): returns - 4 - Failures
-	For	Function: Change Question text:
-	For	Function: Question saved after typing: returns - 4 - Failures and 5 - Errors
-	For	Function: Long word Answer:
-	For	Function: Multi words Answer:
-	For	Function: Space as Answer: returns - 1 - Failure
-	For	Function: Continue without Answer:
-	For	Function: Continue without selected Answer (In Question creation):
-	For	Function: Hebrew text Answer: returns  - 1 - Failure
-	For	Function: Number as Answer:	returns - 1 - Failure
-	For	Function: Singe as Answer:	returns - 1 - Failure
-	For	Function: Question mark as Answer: returns - 1 - Failure
-	For	Function: Change Answer text:
-	For	Function: Answer saved after typing: returns - 4 - Failures
-	For	Function: Answer select saved after selecting (In Question creation): returns - 1 - Failure
-	For	Function: Change right answer:	returns - 1 - Failure
-	For	Function: Back button (In Trivia):
-	For	Function: Continue without selected Answer (In Trivia):
-	For	Function: Answer select saved after selecting (In Trivia):
-	For	Function: Quit button (In let's play): returns - 1 - Failure
-	For	Function: "Try Again" button: returns - 1 - Failure
-	For	Function: Two correct answers: returns - 1 - Failure
-	For	Function: One correct answer: returns - 1 - Failure
-	For	Function: No correct answer: returns - 1 - Failure
-	For	Function: Questions are in random order:	returns - 1 - Failure
-	For	Function: Questions are in random order when try again:	returns - 1 - Failure

3) Boundary Values - The test include 3 Boundary Value tests: 
-	For Max chars Question: returns - 4 - Failures and 6 - Errors
-	For Max chars Question with question mark: returns - 4 - Failures and 6 - Errors
-	For Max chars Answer: 

4) Error Handling - The test include 7 Error Handling tests: 
-	For	Same Questions, Different answers - Select first in Trivia: returns - 1 - Failure
-	For	Same Questions, Different answers - Select second in Trivia: returns - 1 - Failure
-	For	Same Questions, Different answers - Select third  in Trivia: returns - 1 - Failure
-	For	Same Questions, Same answers location - Select first in Trivia: returns - 1 - Failure
-	For	Same Questions, Same answers location - Select second in Trivia: returns - 1 - Failure
-	For	Same Questions, Same answers location - Select third  in Trivia: returns - 1 - Failure
-	For	Same Questions, Same answers - Select fourth in Trivia: returns - 1 - Failure



5) Integration -  The test include 1 test and returns - 1 - Failure

6) Compatibility - The test include 164 tests (Sanity) and runes a total of two times on two different browsers: 
-	For FireFox: returns - 14 - Failures
-	For Internet Explorer: returns - 41 - Failures and 79 - Errors




**Few different findElement methods are used:**<br/>
- StartPage.Java
     - By.id
- QuestionCreationPage.Java
     - By.xpath
- LetsPlayPage.Java
     - By.cssSelector
- TriviaPage.Java
     - By.cssSelector
     - By.xpath
     - By.id
- EndTriviaPage.Java
     - By.cssSelector(Attribute + value) + (dealing with value that have two different values)
     - By.cssSelector(Class)
     - Directly into a List of WebElements

**Few Customized Junit *fail* methods are used:**<br/>
for example:
1. MethodsManager.java (lines 98 - 121)
     - verifyTextIsEqual - When AssertionError is thrown, Two different messages can be shown in the Console:<br/>NOT Empty / NOT Equal.<br/><br/>
2. SanityBase.java (lines 2605 - 2624)
     - WebElements.isDisplayed - if <em><strong>NoSuchElementException</strong></em> is NOT thrown, The test fail.<br/><br/>
3. TriviaFunctionalityTest.java (lines 288 - 305)
     - WebElements.isDisplayed - if <em><strong>NullPointerException</strong></em> is thrown, The test fail.<br/><br/>
4. TriviaFunctionalityTest.java (lines 2395 - 2413)
     - driver.switchTo().alert().accept(); - if <em><strong>NoAlertPresentException</strong></em> is thrown, The test fail.
	 
**How answers are chosen: *getAnswer* and *selectRightAnswer*:**<br/>
for example:
1. SanityBase.java (lines 1812 - 1828)
     - MethodsManager.java >>> getAnswer - Since there is a known bug,<br/>The switch in MethodsManager will return the right answer if it will be present in "questions" or "questionsInTrivia" Arrays.<br/><br/>
2. TriviaFunctionalityTest.java (lines 95 - 98, line 220)
     - MethodsManager.java >>> Set the right answers is a prerequisite to use the getAnswer method, for different answers and questions.	 
     - TrivaActionsManager.Java >>> selectRightAnswer >>> MethodsManager.java >>> getAnswer.
	 
**The Junit test results are written inside the STD with the same test name**<br/>
- The results for the test: "TriviaSanityTest.java", can be found in the file: "Trivia STD - Sanity"
- The STD files also include the total tests that passes,<br/>For example: For the Sanity test "150/164" passes, with 14 - Failures


*Please use the TestsRunnerMain.java class to run the other test classes of the project*  

**The TestsRunnerMain takes approximately 15 minutes and the Junit report should look as follow:**

![image](https://user-images.githubusercontent.com/46252621/52815540-993b9000-30a7-11e9-8580-a8bd77a6546f.png)
