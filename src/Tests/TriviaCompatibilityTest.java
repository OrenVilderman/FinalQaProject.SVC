package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import Utilities.MethodsManager;
import Utilities.SanityBase;

@DisplayName("Trivia Compatibility Tests")
public class TriviaCompatibilityTest extends MethodsManager {
	
	@BeforeAll
	public static void startTesting() {
		System.out.println("Start function: Compatibility tests - Trivia application\n");
	}

	@AfterAll
	public static void endTesting() throws Exception {
		//Thread.sleep(sleepTimers);
		System.out.println("\nEnd function: Compatibility tests - Trivia application\n");
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Trivia Compatibility FireFox Test:")
	// Tests class
	public class TriviaCompatibilityFireFoxTest extends SanityBase {
		
		public TriviaCompatibilityFireFoxTest() throws Exception {
			super(MethodsManager.choserFireFoxDriver());
		}
		
		@BeforeAll
		public void startTesting() throws Exception {
			System.out.println("Start function: Compatibility FireFox browser test (Sanity) - Trivia application\n");
			driver.get(url);
			//Thread.sleep(sleepTimers);
		}

		@AfterAll
		public void endTesting() throws Exception {
			Thread.sleep(sleepTimers);
			driver.quit();
			System.out.println("\nEnd function: Compatibility FireFox browser test (Sanity) - Trivia application\n");
		}
	}

	@Nested
	// LIfe Cycle per class is needed for the before and after all
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Trivia Compatibility Internet Explorer Test")
	// Tests class
	public class TriviaCompatibilityInternetExplorerTest extends SanityBase {

		public TriviaCompatibilityInternetExplorerTest() throws Exception {
			super(MethodsManager.choserInternetExplorerDriver());
		}

		@BeforeAll
		public void startTesting() throws InterruptedException {
			System.out.println("Start function: Compatibility Internet Explorer browser test (Sanity) - Trivia application\n");
			driver.get(url);
			//Thread.sleep(sleepTimers);
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
			System.out.println("\nEnd function: Compatibility Internet Explorer browser test (Sanity) - Trivia application\n");
		}
	}
}