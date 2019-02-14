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

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;

import Utilities.TrivaActionsManager;
import Utilities.MethodsManager;

@DisplayName("Trivia Integration Test")
public class TriviaIntegrationTest extends MethodsManager {

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
		System.out.println("Start function: Integration test - Trivia application\n");
	}

	@AfterAll
	public static void endTesting() throws Exception {
		Thread.sleep(sleepTimers);
		System.out.println("\nEnd function: Integration test - Trivia application\n");
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Facebook button redirect to Facebook site:")
	// Tests class
	public class aaabh extends TrivaActionsManager {

		@BeforeAll
		public void startTesting() {

			// Set MethodsManager before test start
			MethodsManager.choserChromeDriver();
			MethodsManager.questions = new String[] { "a", "b", "c" };
			MethodsManager.questionsInTrivia = new String[] { "a?", "b?", "c?" };
			MethodsManager.answers = new String[] { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
			MethodsManager.rightanswers = new int[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

			System.out.println("Start function: Facebook button redirect to Facebook site Test - Trivia application\n");
			driver.get(url);
			//driver.get(urlFixed); <-- In the local version the Integration with FB bug is fixed


			// Set Pages before test start
			testSite = new StartPage(driver);
			testSite2 = new QuestionCreationPage(driver);
			testSite3 = new LetsPlayPage(driver);
			testSite4 = new TriviaPage(driver);
			testSite5 = new EndTriviaPage(driver);
		}

		@Test
		@DisplayName("1.0) Redirect?")
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
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setTriviaPageElementArr();
				TriviaPageElementArr[5].click();
				TriviaPageElementArr[10].click();
				setEndTriviaPageElementArr();
				EndTriviaPageElementArr[1].click();  // <-- // https://www.facebook.com/sharer.php?u=https://svcollegetest.000webhostapp.com
				driver.switchTo().alert().accept();
				if (!driver.getPageSource().contains("Facebook")) {
					System.out.print("\n" + num + ") Page NOT redirected.");
					System.out.print(" @failure\n");
					fail();
				} else {
					System.out.println("\n" + num + ") Page redirected.");
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
			System.out.println("\nEnd function: Facebook button redirect to Facebook site Test - Trivia application\n");
		}
	}
}