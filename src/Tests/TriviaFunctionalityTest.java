package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Pages.EndTriviaPage;
import Pages.LetsPlayPage;
import Pages.QuestionCreationPage;
import Pages.StartPage;
import Pages.TriviaPage;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;

import Utilities.TrivaActionsManager;
import Utilities.MethodsManager;

@DisplayName("Trivia Functionality Test")
public class TriviaFunctionalityTest extends MethodsManager {

	private static StartPage testSite;
	private static QuestionCreationPage testSite2;
	private static LetsPlayPage testSite3;
	private static TriviaPage testSite4;
	private static EndTriviaPage testSite5;

	private WebElement[] StartPageElementArr;
	private WebElement[] QuestionCreationPageElementArr;
	private WebElement[] LetsPlayPageElementArr;
	private WebElement[] TriviaPageElementArr;
	private WebElement[] EndTriviaPageElementArr;

	// Setters for WebElement Arrays
	private void setStartPageElementArr() throws Exception {
		this.StartPageElementArr = testSite.selectStartPageElement(1);
	}

	private void setQuestionCreationPageElementArr() throws Exception {
		this.QuestionCreationPageElementArr = testSite2.selectQuestionCreationPageElements(13);
	}

	private void setLetsPlayPageElementArr() throws Exception {
		this.LetsPlayPageElementArr = testSite3.selectLetsPlayPageElement(3);
	}

	private void setTriviaPageElementArr() throws Exception {
		this.TriviaPageElementArr = testSite4.selectTriviaPageElement(12);
	}

	private void setEndTriviaPageElementArr() throws Exception {
		this.EndTriviaPageElementArr = testSite5.selectEndTriviaPageElement(4);
	}

	// To be called from TriviaActionsManager.
	public static WebElement[] NewTriviaPageElementArr() throws Exception {
		WebElement[] NewTriviaPageElementArr = testSite4.selectTriviaPageElement(12);
		return NewTriviaPageElementArr;
	}

	@BeforeAll
	public static void startTesting() {
		System.out.println("Start function: Functionality tests - Trivia application\n");
	}

	@AfterAll
	public static void endTesting() throws Exception {
		Thread.sleep(sleepTimers);
		System.out.println("\nEnd function: Functionality tests - Trivia application\n");
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Long word Question:")
	// Tests class
	public class aaaaa extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "abcdefg", "abcdefgh", "abcdefghi" };
			MethodsManager.questionsInTrivia = new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Long word Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = questions[0];
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[3].click();
		}

		@Test
		@DisplayName("3.0) Question input box text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			String questionTwo = questions[1];
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
		}

		@Test
		@DisplayName("4.0) First radio button Is Visible?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[4].click();
		}

		@Test
		@DisplayName("5.0) Question input box text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionThree = questions[2];
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionThree, num);
		}

		@Test
		@DisplayName("6.0) First radio button Is Visible?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[5].click();
		}

		@Test
		@DisplayName("7.0) Text Is Equal?")
		public void aaag() throws Exception {
			String num = "7.0";
			String letsPlayHadline = "You finished to build the test - lets play!!";
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) First radio button Is Visible?")
		public void aaah() throws Exception {
			String num = "8.0";
			Thread.sleep(sleepTimers);
			try {
				LetsPlayPageElementArr[1].click();
				setTriviaPageElementArr();
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.1) Text Is Equal?")
		public void aaai() throws Exception {
			String num = "8.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The First question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("9.0) First radio button Is Visible?")
		public void aaaj() throws Exception {
			String num = "9.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.1) Text Is Equal?")
		public void aaak() throws Exception {
			String num = "9.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Second question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("10.0) First radio button Is Visible?")
		public void aaal() throws Exception {
			String num = "10.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.1) Text Is Equal?")
		public void aaam() throws Exception {
			String num = "10.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Third question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("11.0) First radio button Is Visible?")
		public void aaan() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			try {
				setTriviaPageElementArr();
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Long word Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Multi words Question:")
	// Tests class
	public class aaaab extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "aaaaa bbbbb ccccc", "bbbbb aaaaa ccccc", "ccccc bbbbb aaaaa" };
			MethodsManager.questionsInTrivia = new String[] { "aaaaa bbbbb ccccc?", "bbbbb aaaaa ccccc?", "ccccc bbbbb aaaaa?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Multi words Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = questions[0];
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[3].click();
		}

		@Test
		@DisplayName("3.0) Question input box text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			String questionTwo = questions[1];
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
		}

		@Test
		@DisplayName("4.0) First radio button Is Visible?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[4].click();
		}

		@Test
		@DisplayName("5.0) Question input box text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionThree = questions[2];
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionThree, num);
		}

		@Test
		@DisplayName("6.0) First radio button Is Visible?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[5].click();
		}

		@Test
		@DisplayName("7.0) Text Is Equal?")
		public void aaag() throws Exception {
			String num = "7.0";
			String letsPlayHadline = "You finished to build the test - lets play!!";
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) First radio button Is Visible?")
		public void aaah() throws Exception {
			String num = "8.0";
			Thread.sleep(sleepTimers);
			try {
				LetsPlayPageElementArr[1].click();
				setTriviaPageElementArr();
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.1) Text Is Equal?")
		public void aaai() throws Exception {
			String num = "8.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The First question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("9.0) First radio button Is Visible?")
		public void aaaj() throws Exception {
			String num = "9.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.1) Text Is Equal?")
		public void aaak() throws Exception {
			String num = "9.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Second question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("10.0) First radio button Is Visible?")
		public void aaal() throws Exception {
			String num = "10.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.1) Text Is Equal?")
		public void aaam() throws Exception {
			String num = "10.1";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			try {
				questionIs = TriviaPageElementArr[1].getText();
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefg?", "abcdefgh?", "abcdefghi?" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Third question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("11.0) First radio button Is Visible?")
		public void aaan() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			try {
				setTriviaPageElementArr();
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Multi words Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Space as Question:")
	// Tests class
	public class aaaac extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Space as Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = " ";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Space as Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Continue without Question:")
	// Tests class
	public class aaaad extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Continue without Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			Thread.sleep(sleepTimers);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Continue without Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Hebrew Text Question:")
	// Tests class
	public class aaaae extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Hebrew Text Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "à";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Hebrew Text Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Number as Question:")
	// Tests class
	public class aaaaf extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Number as Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "1";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Number as Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Singe as Question:")
	// Tests class
	public class aaaag extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Singe as Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "@";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Singe as Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Question mark as Question:")
	// Tests class
	public class aaaah extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Question mark as Question Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Question input box text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "?";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Question mark as Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Back button [In Question Creation]:")
	// Tests class
	public class aaaai extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Back button (In Question Creation) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[3].click();
			String questionTwo = "b";
			Thread.sleep(sleepTimers);
			testSite2 = new QuestionCreationPage(driver);
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			QuestionCreationPageElementArr[11].click();
			testSite2 = new QuestionCreationPage(driver);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[4].click();
			String questionThree = "c";
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			QuestionCreationPageElementArr[11].click();
			QuestionCreationPageElementArr[12].click();
			String questionHadline = "Please type here your question :" + "\n" + "question number: 3";
			Thread.sleep(sleepTimers);
			testSite2 = new QuestionCreationPage(driver);
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Text Is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			String answerHadline = "Please enter 4 possible answers and Mark the right one!" + "\n" + "question number: 2";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[12].click();
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, answerHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Text Is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			String questionHadline = "Please type here your question :" + "\n" + "question number: 2";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[12].click();
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Text Is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			String answerHadline = "Please enter 4 possible answers and Mark the right one!" + "\n" + "question number: 1";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[12].click();
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, answerHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) Text Is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionHadline = "Please type here your question :" + "\n" + "question number: 1";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[12].click();
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Back button (In Question Creation) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Change Question text:")
	// Tests class
	public class aaaaj extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "q", "w", "e" };
			MethodsManager.questionsInTrivia = new String[] { "q?", "w?", "e?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Change Question text Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First radio button Is Visible?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			try {
				setStartPageElementArr();
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
				QuestionCreationPageElementArr[11].click();
				QuestionCreationPageElementArr[12].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Text Is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			String questionOne = "q";
			try {
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[1].clear();
				QuestionCreationPageElementArr[1].sendKeys(questionOne);
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) First radio button Is Visible?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) First radio button Is Visible?")
		public void aaad() throws Exception {
			String num = "4.0";
			String questionTwo = "b";
			try {
				setStartPageElementArr();
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
				QuestionCreationPageElementArr[3].click();
				TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
				QuestionCreationPageElementArr[11].click();
				QuestionCreationPageElementArr[12].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) Text Is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionTwo = "w";
			try {
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[1].clear();
				QuestionCreationPageElementArr[1].sendKeys(questionTwo);
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("6.0) First radio button Is Visible?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("7.0) First radio button Is Visible?")
		public void aaag() throws Exception {
			String num = "7.0";
			String questionThree = "c";
			try {
				setStartPageElementArr();
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
				QuestionCreationPageElementArr[3].click();
				TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
				QuestionCreationPageElementArr[11].click();
				QuestionCreationPageElementArr[12].click();
				boolean isDisplayed = QuestionCreationPageElementArr[3].isDisplayed();
				if (!isDisplayed) {
					System.out.println(num + ") First radio button Is NOT Visible");
				} else {
					System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if NOT Displayed
					System.out.println(" @failure\n"); // Test pass only if NOT Displayed
					fail(); // Test pass only if NOT Displayed
				}
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) Text Is Equal?")
		public void aaah() throws Exception {
			String num = "8.0";
			String questionThree = "e";
			try {
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[1].clear();
				QuestionCreationPageElementArr[1].sendKeys(questionThree);
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionThree, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.0) First radio button Is Visible?")
		public void aaai() throws Exception {
			String num = "9.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.0) Text Is Equal?")
		public void aaaj() throws Exception {
			String num = "10.0";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[5].click();
			QuestionCreationPageElementArr[11].click();
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			try {

				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "q", "w", "e" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Second question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("11.0) Text Is Equal?")
		public void aaak() throws Exception {
			String num = "11.0";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			try {

				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "q", "w", "e" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Second question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("12.0) Text Is Equal?")
		public void aaal() throws Exception {
			String num = "12.0";
			String questionIs = "";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			try {

				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "q", "w", "e" }, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The Second question is: " + questionIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("13.0) First radio button Is Visible?")
		public void aaam() throws Exception {
			String num = "13.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Change Question text Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Question saved after typing:")
	// Tests class
	public class aaaak extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Question saved after typing Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First radio button Is Visible?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			try {
				setStartPageElementArr();
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) First radio button Is Visible?")
		public void aaab() throws Exception {
			String num = "2.0";
			String questionTwo = "b";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[3].click();
			QuestionCreationPageElementArr[11].click();
			try {
				QuestionCreationPageElementArr[1].sendKeys(questionTwo);
				QuestionCreationPageElementArr[12].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Text Is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			String questionTwo = "b";
			try {
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) First radio button Is Visible?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) First radio button Is Visible?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionThree = "c";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[4].click();
			QuestionCreationPageElementArr[11].click();
			try {
				QuestionCreationPageElementArr[1].sendKeys(questionThree);
				QuestionCreationPageElementArr[12].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("6.0) Text Is Equal?")
		public void aaaf() throws Exception {
			String num = "6.0";
			String questionTwo = "c";
			try {
				Thread.sleep(sleepTimers);
				setQuestionCreationPageElementArr();
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("7.0) First radio button Is Visible?")
		public void aaag() throws Exception {
			String num = "7.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) First radio button text Is Equal?")
		public void aaah() throws Exception {
			String num = "8.0";
			String firstAnswer = "a";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[5].click();
			QuestionCreationPageElementArr[11].click();
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 6, firstAnswer, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.0) First radio button text Is Equal?")
		public void aaai() throws Exception {
			String num = "9.0";
			String firstAnswer = "a";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			// setTriviaPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 6, firstAnswer, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.0) First radio button text Is Equal?")
		public void aaaj() throws Exception {
			String num = "10.0";
			String firstAnswer = "a";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			// setTriviaPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 6, firstAnswer, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("11.0) First radio button Is Visible?")
		public void aaak() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			// setTriviaPageElementArr();
			try {
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Question saved after typing Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Long word Answer:")
	// Tests class
	public class aaaal extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij",
					"abcdefg", "abcdefgh", "abcdefghi", "abcdefghij",
					"abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Long word Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefg", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Second answer box input text is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefgh", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Third answer box input text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghi", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Fourth answer box input text is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghij", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) First answer box input text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionTwo = "b";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[3].click();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefg", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("6.0) Second answer box input text is Equal?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefgh", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("7.0) Third answer box input text is Equal?")
		public void aaag() throws Exception {
			String num = "7.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghi", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) Fourth answer box input text is Equal?")
		public void aaah() throws Exception {
			String num = "8.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghij", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.0) First answer box input text is Equal?")
		public void aaai() throws Exception {
			String num = "9.0";
			String questionThree = "c";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[4].click();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefg", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.0) Second answer box input text is Equal?")
		public void aaaj() throws Exception {
			String num = "10.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefgh", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("11.0) Third answer box input text is Equal?")
		public void aaak() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghi", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("12.0) Fourth answer box input text is Equal?")
		public void aaal() throws Exception {
			String num = "12.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghij", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("13.0) Text Is Equal?")
		public void aaam() throws Exception {
			String num = "13.0";
			String letsPlayHadline = "You finished to build the test - lets play!!";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[5].click();
			QuestionCreationPageElementArr[11].click();
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("14.0) First radio button Is Visible?")
		public void aaan() throws Exception {
			String num = "14.0";
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("15.0) Text Is Equal?")
		public void aaao() throws Exception {
			String num = "15.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" };
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("16.0) Text Is Equal?")
		public void aaap() throws Exception {
			String num = "16.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" };

			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("17.0) Text Is Equal?")
		public void aaaq() throws Exception {
			String num = "17.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "abcdefg", "abcdefgh", "abcdefghi", "abcdefghij" };

			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("18.0) First radio button Is Visible?")
		public void aaat() throws Exception {
			String num = "18.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Long word Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Multi words Answer:")
	// Tests class
	public class aaaam extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc",
					"aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc",
					"aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Multi words Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "aaa bbb ccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Second answer box input text is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "aaaa bbbb ccvc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Third answer box input text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "aaaaa bbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Fourth answer box input text is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "aaaaaa bbbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) First answer box input text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			String questionTwo = "b";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[3].click();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "aaa bbb ccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("6.0) Second answer box input text is Equal?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "aaaa bbbb ccvc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("7.0) Third answer box input text is Equal?")
		public void aaag() throws Exception {
			String num = "7.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "aaaaa bbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) Fourth answer box input text is Equal?")
		public void aaah() throws Exception {
			String num = "8.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "aaaaaa bbbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.0) First answer box input text is Equal?")
		public void aaai() throws Exception {
			String num = "9.0";
			String questionThree = "c";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[4].click();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "aaa bbb ccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.0) Second answer box input text is Equal?")
		public void aaaj() throws Exception {
			String num = "10.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "aaaa bbbb ccvc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("11.0) Third answer box input text is Equal?")
		public void aaak() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "aaaaa bbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("12.0) Fourth answer box input text is Equal?")
		public void aaal() throws Exception {
			String num = "12.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "aaaaaa bbbbbb cccccc", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("13.0) Text Is Equal?")
		public void aaam() throws Exception {
			String num = "13.0";
			String letsPlayHadline = "You finished to build the test - lets play!!";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[5].click();
			QuestionCreationPageElementArr[11].click();
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("14.0) First radio button Is Visible?")
		public void aaan() throws Exception {
			String num = "14.0";
			Thread.sleep(sleepTimers);
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			try {
				MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 2, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("15.0) Text Is Equal?")
		public void aaao() throws Exception {
			String num = "15.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" };
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("16.0) Text Is Equal?")
		public void aaap() throws Exception {
			String num = "16.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" };
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("17.0) Text Is Equal?")
		public void aaaq() throws Exception {
			String num = "17.0";
			String answerAre[] = new String[4];
			String answerShouldBe[] = new String[] { "aaa bbb ccc", "aaaa bbbb ccvc", "aaaaa bbbbb cccccc", "aaaaaa bbbbbb cccccc" };
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerAre[0] = TriviaPageElementArr[6].getText();
				answerAre[1] = TriviaPageElementArr[7].getText();
				answerAre[2] = TriviaPageElementArr[8].getText();
				answerAre[3] = TriviaPageElementArr[9].getText();
				for (int i = 0; i < 4; i++) {
					assertEquals(answerShouldBe[i], answerAre[i]);
				}
				System.out.println(num + ") Question Text Is Equal.");

			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + Arrays.toString(answerAre));
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("18.0) First radio button Is Visible?")
		public void aaat() throws Exception {
			String num = "18.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: multi words Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Space as Answer:")
	// Tests class
	public class aaaan extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Space as Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { " ", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, " ", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Space as Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Continue without Answer:")
	// Tests class
	public class aaaao extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Continue without Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Continue without Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Continue without selected Answer [In Question creation]:")
	// Tests class
	public class aaaap extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Test Function: Continue without selected Answer (In Question creation) : Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "a", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, false, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Test Function: Continue without selected Answer (In Question creation) : Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Hebrew text Answer:")
	// Tests class
	public class aaaaq extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Hebrew text Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "à", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "à", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Hebrew text Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Number as Answer:")
	// Tests class
	public class aaaar extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Number as Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "1", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "1", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Number as Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("singe as Answer:")
	// Tests class
	public class aaaas extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: singe as Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "@", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "@", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: singe as Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Question mark as Answer:")
	// Tests class
	public class aaaat extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Question mark as Answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "?", "b", "c", "d" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "?", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Alert Is Present?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Question mark as Answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Change Answer text:")
	// Tests class
	public class aaaau extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "q", "w", "e", "r", "q", "w", "e", "r", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Change Answer text Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) First answer box input text is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			Thread.sleep(sleepTimers);
			String questionOne = "a";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[3].click();
			try {
				QuestionCreationPageElementArr[7].clear();
				QuestionCreationPageElementArr[7].sendKeys("q");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "q", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Second answer box input text is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[8].clear();
				QuestionCreationPageElementArr[8].sendKeys("w");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "w", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Third answer box input text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[9].clear();
				QuestionCreationPageElementArr[9].sendKeys("e");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "e", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Fourth answer box input text is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[10].clear();
				QuestionCreationPageElementArr[10].sendKeys("r");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "r", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) First answer box input text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			Thread.sleep(sleepTimers);
			String questionTwo = "b";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[4].click();
			try {
				QuestionCreationPageElementArr[7].clear();
				QuestionCreationPageElementArr[7].sendKeys("q");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "q", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("6.0) Second answer box input text is Equal?")
		public void aaaf() throws Exception {
			String num = "6.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[8].clear();
				QuestionCreationPageElementArr[8].sendKeys("w");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "w", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("7.0) Third answer box input text is Equal?")
		public void aaag() throws Exception {
			String num = "7.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[9].clear();
				QuestionCreationPageElementArr[9].sendKeys("e");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "e", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("8.0) Fourth answer box input text is Equal?")
		public void aaah() throws Exception {
			String num = "8.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[10].clear();
				QuestionCreationPageElementArr[10].sendKeys("r");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "r", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("9.0) First answer box input text is Equal?")
		public void aaai() throws Exception {
			String num = "9.0";
			Thread.sleep(sleepTimers);
			String questionThree = "c";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			QuestionCreationPageElementArr[5].click();
			try {
				QuestionCreationPageElementArr[7].clear();
				QuestionCreationPageElementArr[7].sendKeys("q");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "q", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("10.0) Second answer box input text is Equal?")
		public void aaaj() throws Exception {
			String num = "10.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[8].clear();
				QuestionCreationPageElementArr[8].sendKeys("w");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "w", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("11.0) Third answer box input text is Equal?")
		public void aaak() throws Exception {
			String num = "11.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[9].clear();
				QuestionCreationPageElementArr[9].sendKeys("e");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "e", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("12.0) Fourth answer box input text is Equal?")
		public void aaal() throws Exception {
			String num = "12.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[10].clear();
				QuestionCreationPageElementArr[10].sendKeys("r");
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "r", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("13.0) Text Is Equal?")
		public void aaam() throws Exception {
			String num = "13.0";
			String answerIs = "";
			String answerShouldBe = "q";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			try {
				answerIs = TriviaPageElementArr[6].getText();
				assertEquals(answerShouldBe, answerIs);
				System.out.println(num + ") Question Text Is Equal.");
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + answerIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("14.0) Text Is Equal?")
		public void aaan() throws Exception {
			String num = "14.0";
			String answerIs = "";
			String answerShouldBe = "q";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerIs = TriviaPageElementArr[6].getText();
				assertEquals(answerShouldBe, answerIs);
				System.out.println(num + ") Question Text Is Equal.");
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + answerIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("15.0) Text Is Equal?")
		public void aaao() throws Exception {
			String num = "15.0";
			String answerIs = "";
			String answerShouldBe = "q";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				answerIs = TriviaPageElementArr[6].getText();
				assertEquals(answerShouldBe, answerIs);
				System.out.println(num + ") Question Text Is Equal.");
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			} finally {
				System.out.println("The answers are: " + answerIs);
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			}
		}

		@Test
		@DisplayName("16.0) First radio button Is Visible?")
		public void aaap() throws Exception {
			String num = "16.0";
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				TriviaPageElementArr[2].isDisplayed();
				System.out.print("\n" + num + ") First radio button is Visible."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NullPointerException noRadioButton) {
				System.out.println("\n" + num + ") WebElement Is NOT visible."); // not Visible is the condition to pass the test by the STD
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Change Answer text Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Answer saved after typing:")
	// Tests class
	public class aaaav extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Answer saved after typing Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			String questionHadline = "Please type here your question :" + "\n" + "question number: 1";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				QuestionCreationPageElementArr[12].click();
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) First answer box input text is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "a", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Second answer box input text is Equal?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {

				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "b", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Third answer box input text is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {

				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "c", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("5.0) Fourth answer box input text is Equal?")
		public void aaae() throws Exception {
			String num = "5.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			try {
				;
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "d", num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Answer saved after typing Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Answer select saved after selecting [In Question creation]:")
	// Tests class
	public class aaaaw extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: : Answer select saved after selecting (In Question creation) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Radio button Is Selected?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				QuestionCreationPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Text Is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			String questionHadline = "Please type here your question :" + "\n" + "question number: 1";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[12].click();
			try {
				MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Radio button Is Selected?")
		public void aaac() throws Exception {
			String num = "3.0";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			try {
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Answer select saved after selecting (In Question creation) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Change right answer:")
	// Tests class
	public class aaaax extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Change right answer Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Radio button Is Selected?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String questionOne = "a";
			setStartPageElementArr();
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionOne);
			QuestionCreationPageElementArr[11].click();
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				QuestionCreationPageElementArr[3].click();
				QuestionCreationPageElementArr[4].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 4, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Radio button Is Selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			String questionTwo = "b";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionTwo);
			QuestionCreationPageElementArr[11].click();
			testSite2 = new QuestionCreationPage(driver);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				QuestionCreationPageElementArr[4].click();
				QuestionCreationPageElementArr[5].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 5, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Radio button Is Selected?")
		public void aaac() throws Exception {
			String num = "3.0";
			String questionThree = "c";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			TrivaActionsManager.fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questionThree);
			QuestionCreationPageElementArr[11].click();
			Thread.sleep(sleepTimers);
			testSite2 = new QuestionCreationPage(driver);
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr, new String[] { "a", "b", "c", "d" });
			try {
				QuestionCreationPageElementArr[5].click();
				QuestionCreationPageElementArr[6].click();
				MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 6, true, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("4.0) Text Is Equal?")
		public void aaad() throws Exception {
			String num = "4.0";
			String endHadline = "Success!!";
			Thread.sleep(sleepTimers);
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			setTriviaPageElementArr();
			TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
			setEndTriviaPageElementArr();
			try {
				MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Change right answer Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Back button [In Trivia]:")
	// Tests class
	public class aaaay extends TrivaActionsManager {

		private String questionOneIs = "";
		private String questioTwonIs = "";

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Back button (In Trivia) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				questionOneIs = TriviaPageElementArr[1].getText();
				TrivaActionsManager.selectRightAnswer(TriviaPageElementArr, num);
				setTriviaPageElementArr();
				questioTwonIs = TriviaPageElementArr[1].getText();
				System.out.println("The first question is: " + questionOneIs);
				System.out.println("The Second question is: " + questioTwonIs);
				TriviaPageElementArr[11].click();
				setTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 1, questionOneIs, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Text Is Equal?")
		public void aaab() throws Exception {
			String num = "2.0";
			setTriviaPageElementArr();
			try {
				Thread.sleep(sleepTimers);
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 1, questioTwonIs, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Back button (In Trivia) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Continue without selected Answer [In Trivia]:")
	// Tests class
	public class aaaaz extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Continue without selected Answer (In Trivia) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Alert Is Present?")
		public void aaaa() throws Exception {
			String num = "1.0";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[10].click();
				driver.switchTo().alert().accept();
				System.out.println(num + ") Alert Is Present.");
			} catch (NoAlertPresentException e) {
				System.out.print("\n" + num + ") Alert Is NOT Present.");
				System.out.println(" @failure\n");
				fail();
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Continue without selected Answer (In Trivia) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Answer select saved after selecting [In Trivia]:")
	// Tests class
	public class aaaba extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Answer select saved after selecting (In Trivia) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Second radio button Is selected?")
		public void aaaa() throws Exception {
			String num = "1.0";
			boolean radioTwo = true;
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, 3, radioTwo, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) First radio button Is selected?")
		public void aaab() throws Exception {
			String num = "2.0";
			boolean radioOne = true;
			setTriviaPageElementArr();
			Thread.sleep(sleepTimers);
			try {
				TriviaPageElementArr[11].click();
				setTriviaPageElementArr();
				MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, 2, radioOne, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("3.0) Second radio button Is selected?")
		public void aaac() throws Exception {
			String num = "3.0";
			boolean radioTwo = true;
			Thread.sleep(sleepTimers);
			setTriviaPageElementArr();
			try {
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, 3, radioTwo, num);
			} catch (Exception e) {
				System.err.println(num + ") Radio button: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Answer select saved after selecting (In Trivia) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Quit button [In let's play]:")
	// Tests class
	public class aaabb extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Quit button (In let's play) Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String letsPlayHadline = "You finished to build the test - lets play!!";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questions[0]);
				QuestionCreationPageElementArr[11].click();
				fillAnswers(QuestionCreationPageElementArr, answers);
				QuestionCreationPageElementArr[3].click();
				fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questions[1]);
				QuestionCreationPageElementArr[11].click();
				fillAnswers(QuestionCreationPageElementArr, answers);
				QuestionCreationPageElementArr[4].click();
				fillQuestion(StartPageElementArr, QuestionCreationPageElementArr, questions[2]);
				QuestionCreationPageElementArr[11].click();
				fillAnswers(QuestionCreationPageElementArr, answers);
				QuestionCreationPageElementArr[5].click();
				QuestionCreationPageElementArr[11].click();
				MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Triva app is closed?")
		protected void aaab() throws Exception {
			String num = "2.0";
			Thread.sleep(sleepTimers);
			try {
				LetsPlayPageElementArr[2].click();
				driver.findElement(By.xpath("/html/body/div[1]/header/img")).isDisplayed();
				System.out.print("\n" + num + ") Triva app is closed."); // Test pass only if exception is thrown
				System.out.println(" @failure\n"); // Test pass only if exception is thrown
				fail(); // Test pass only if exception is thrown
			} catch (NoSuchElementException closed) {
				System.out.println(num + ") Triva app is closed.");
			} catch (Exception e) {
				System.err.println(num + ") UnExpeted Error: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Quit button (In let's play) Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("\"Try Again\" button")
	// Tests class
	public class aaabc extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: \"Try Again\" button Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String endHadline = "Success!!";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				TrivaActionsManager.fastPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers, endHadline);
				setEndTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@Test
		@DisplayName("2.0) Text Is Equal?")
		protected void aaab() throws Exception {
			String num = "2.0";
			String answerHadline = "Test";
			Thread.sleep(sleepTimers);
			try {
				EndTriviaPageElementArr[2].click();
				setTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 0, answerHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: \"Try Again\" button Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Two correct answers")
	// Tests class
	public class aaabd extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Two correct answers Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String endHadline = "Failed!!";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				TrivaActionsManager.fastPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers, endHadline);
				setEndTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Two correct answers Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("One correct answers")
	// Tests class
	public class aaabe extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: One correct answers Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String endHadline = "Failed!!";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				TrivaActionsManager.fastPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers, endHadline);
				setEndTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: One correct answers Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("No correct answers")
	// Tests class
	public class aaabf extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: No correct answers Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			String endHadline = "Failed!!";
			Thread.sleep(sleepTimers);
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				TrivaActionsManager.fastPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers, endHadline);
				setEndTriviaPageElementArr();
				MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
			} catch (Exception e) {
				System.err.println(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: No correct answers Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Questions are in random order:")
	// Tests class
	public class aaabg extends TrivaActionsManager {

		private String questionOneIs = "";
		private String questionTwoIs = "";
		// private String questionThreeIs = "";
		private String questionFourIs = "";
		private String questionFiveIs = "";
		// private String questionSixIs = "";
		private String questionSevenIs = "";
		private String questionEightIs = "";
		// private String questionNineIs = "";

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Questions are in random order Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			try {
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				questionOneIs = TriviaPageElementArr[1].getText();
				System.out.println("The first question is: " + questionOneIs);
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionTwoIs = TriviaPageElementArr[1].getText();
				System.out.println("The Second question is: " + questionTwoIs);
				driver.navigate().refresh();
				driver.switchTo().alert().accept();
				setStartPageElementArr();
				setQuestionCreationPageElementArr();
				setLetsPlayPageElementArr();
				setTriviaPageElementArr();
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				questionFourIs = TriviaPageElementArr[1].getText();
				System.out.println("The Fourth question is: " + questionFourIs);
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionFiveIs = TriviaPageElementArr[1].getText();
				System.out.println("The Fifth question is: " + questionFiveIs);
				driver.get(driver.getCurrentUrl());
				driver.switchTo().alert().accept();
				setStartPageElementArr();
				setQuestionCreationPageElementArr();
				setLetsPlayPageElementArr();
				setTriviaPageElementArr();
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				questionSevenIs = TriviaPageElementArr[1].getText();
				System.out.println("The Seventh question is: " + questionSevenIs);
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionEightIs = TriviaPageElementArr[1].getText();
				System.out.println("The Eighth question is: " + questionEightIs);
				if ((questionOneIs.equals(questionFourIs) && questionOneIs.equals(questionSevenIs))
						&& (questionTwoIs.equals(questionFiveIs) && questionTwoIs.equals(questionEightIs))) {
					System.out.print("\n" + num + ") Text Is Equal.");
					System.out.print(" @failure\n");
					fail();
				} else {
					System.out.println("\n" + num + ") Text Is NOT Equal.");

				}
			} catch (Exception e) {
				System.err.print(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Questions are in random order Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Questions are in random order when try again:")
	// Tests class
	public class aaabh extends TrivaActionsManager {

		private String questionOneIs = "";
		private String questionTwoIs = "";
		// private String questionThreeIs = "";
		private String questionFourIs = "";
		private String questionFiveIs = "";
		// private String questionSixIs = "";
		private String questionSevenIs = "";
		private String questionEightIs = "";
		// private String questionNineIs = "";

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Questions are in random order when try again Test - Trivia application\n");
			driver.get(url);

			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Text Is Equal?")
		public void aaaa() throws Exception {
			String num = "1.0";
			setStartPageElementArr();
			setQuestionCreationPageElementArr();
			setLetsPlayPageElementArr();
			setTriviaPageElementArr();
			
			try {
				Thread.sleep(sleepTimers);
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				questionOneIs = TriviaPageElementArr[1].getText();
				System.out.println("The first question is: " + questionOneIs);
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionTwoIs = TriviaPageElementArr[1].getText();
				System.out.println("The Second question is: " + questionTwoIs);
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setEndTriviaPageElementArr();
				EndTriviaPageElementArr[2].click();
				setTriviaPageElementArr();
				questionFourIs = TriviaPageElementArr[1].getText();
				System.out.println("The Fourth question is: " + questionFourIs);
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionFiveIs = TriviaPageElementArr[1].getText();
				System.out.println("The Fifth question is: " + questionFiveIs);
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setEndTriviaPageElementArr();
				EndTriviaPageElementArr[2].click();
				setTriviaPageElementArr();
				questionSevenIs = TriviaPageElementArr[1].getText();
				System.out.println("The Seventh question is: " + questionSevenIs);
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				questionEightIs = TriviaPageElementArr[1].getText();
				System.out.println("The Eighth question is: " + questionEightIs);
				if ((questionOneIs.equals(questionFourIs) && questionOneIs.equals(questionSevenIs))
						&& (questionTwoIs.equals(questionFiveIs) && questionTwoIs.equals(questionEightIs))) {
					System.out.print("\n" + num + ") Text Is Equal.");
					System.out.print(" @failure\n");
					fail();
				} else {
					System.out.println("\n" + num + ") Text Is NOT Equal.");

				}
			} catch (Exception e) {
				System.err.print(num + ") Element is not visible: Error." + e.getClass());
				throw new Exception("Error");
			}
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			try {
				driver.close();
			} catch (Exception e) {
				System.err.println("The driver was closed Error." + e.getClass());
				// driver.switchTo().alert().accept();
			}
			System.out.println("\nEnd function: Questions are in random order when try again Test - Trivia application\n");
		}
	}
}