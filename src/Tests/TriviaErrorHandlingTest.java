package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebElement;

import Pages.EndTriviaPage;
import Pages.LetsPlayPage;
import Pages.QuestionCreationPage;
import Pages.StartPage;
import Pages.TriviaPage;

import org.junit.jupiter.api.AfterAll;

import Utilities.TrivaActionsManager;
import Utilities.MethodsManager;

@DisplayName("Trivia Error Handling Test")
public class TriviaErrorHandlingTest extends MethodsManager {

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
		System.out.println("Start function: Error Handling tests - Trivia application\n");
	}

	@AfterAll
	public static void endTesting() throws Exception {
		Thread.sleep(sleepTimers);
		System.out.println("\nEnd function: Error Handling tests - Trivia application\n");
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Different answers – Select first in Trivia:")
	// Tests class
	public class aaaaa extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Different answers – Select first in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Different answers – Select first in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Different answers – Select second in Trivia:")
	// Tests class
	public class aaaab extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Different answers – Select second in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Different answers – Select second in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Different answers – Select third in Trivia:")
	// Tests class
	public class aaaac extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Different answers – Select third in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Different answers – Select third in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Same answers location – Select first in Trivia:")
	// Tests class
	public class aaaad extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "b", "a", "c", "d", "c", "b", "a", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Same answers location – Select first in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[2].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Same answers location – Select first in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Same answers location – Select second in Trivia:")
	// Tests class
	public class aaaae extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "b", "a", "c", "d", "c", "b", "a", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Same answers location – Select second in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[3].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Same answers location – Select second in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Same answers location – Select third in Trivia:")
	// Tests class
	public class aaaaf extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "b", "a", "c", "d", "c", "b", "a", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Same answers location – Select third in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[4].click();
				TriviaPageElementArr[10].click();
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
			System.out.println("\nEnd function: Same Questions, Same answers location – Select third in Trivia Test - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Same Questions, Same answers – Select fourth in Trivia – Select third in Trivia:")
	// Tests class
	public class aaaag extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "a", "a" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "a?", "a?" };
			MethodsManager.answers = new String[] { "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Same Questions, Same answers – Select fourth in Trivia Test - Trivia application\n");
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
				TrivaActionsManager.letsPlay(StartPageElementArr, QuestionCreationPageElementArr, LetsPlayPageElementArr, TriviaPageElementArr, questions, answers);
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
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
			try {
				driver.close();
			} catch (Exception e) {
				System.err.println("The driver was closed Error." + e.getClass());
				// driver.switchTo().alert().accept();
			}
			System.out.println("\nEnd function: Same Questions, Same answers – Select fourth in Trivia Test - Trivia application\n");
		}
	}
}