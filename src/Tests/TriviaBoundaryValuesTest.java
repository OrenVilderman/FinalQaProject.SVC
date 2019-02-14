package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;

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

@DisplayName("Trivia Boundary Values Test")
public class TriviaBoundaryValuesTest extends MethodsManager {

	private static StartPage testSite;
	private static QuestionCreationPage testSite2;
	private static LetsPlayPage testSite3;
	private static TriviaPage testSite4;

	private WebElement[] StartPageElementArr;
	private WebElement[] QuestionCreationPageElementArr;
	private WebElement[] LetsPlayPageElementArr;
	private WebElement[] TriviaPageElementArr;

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

	// To be called from TriviaActionsManager.
	public static WebElement[] NewTriviaPageElementArr() throws Exception {
		WebElement[] NewTriviaPageElementArr = testSite4.selectTriviaPageElement(12);
		return NewTriviaPageElementArr;
	}

	@BeforeAll
	public static void startTesting() {
		System.out.println("Start function: Boundary Values tests - Trivia application\n");
	}

	@AfterAll
	public static void endTesting() throws Exception {
		Thread.sleep(sleepTimers);
		System.out.println("\nEnd function: Boundary Values tests - Trivia application\n");
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Max chars Question:")
	// Tests class
	public class aaaaa extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions =
					new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" };
			MethodsManager.questionsInTrivia = new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Max chars Question Test - Trivia application\n");
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
			System.out.println("\nEnd function: Max chars Question Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Max chars Question with question mark :")
	// Tests class
	public class aaaab extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" };
			MethodsManager.questionsInTrivia = new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
					"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Max chars Question with question mark Test - Trivia application\n");
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
				MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, new String[] { "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?",
						"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij?" }, num);
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
			System.out.println("\nEnd function: Max chars Question with question mark Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Max chars Answer:")
	// Tests class
	public class aaaac extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij",
					"abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij",
					"abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Max chars Answer Test - Trivia application\n");
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
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr,
					new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghijabcdefghijabcdefghij", num);
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
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr,
					new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghijabcdefghijabcdefghij", num);
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
			TrivaActionsManager.fillAnswers(QuestionCreationPageElementArr,
					new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" });
			try {
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, "abcdefghijabcdefghijabcdefghij", num);
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
				MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, "abcdefghijabcdefghijabcdefghij", num);
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
			String answerShouldBe[] = new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" };
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
			String answerShouldBe[] = new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" };
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
			String answerShouldBe[] = new String[] { "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij", "abcdefghijabcdefghijabcdefghij" };
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
			try {
				driver.close();
			} catch (Exception e) {
				System.err.println("The driver was closed Error." + e.getClass());
				// driver.switchTo().alert().accept();
			}
			System.out.println("\nEnd function: Max chars Answer Test - Trivia application\n");
		}
	}
}