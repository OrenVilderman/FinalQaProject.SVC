package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;

import Utilities.MethodsManager;
import Utilities.SanityBase;

@DisplayName("Trivia Sanity Test")
public class TriviaSanityTest extends SanityBase {

	public TriviaSanityTest() throws Exception {
	}

	@BeforeAll
	public static void startTesting() throws InterruptedException {
		System.out.println("Start function: Sanity test - Trivia application\n");
		MethodsManager.choserChromeDriver();
		driver.get(url);
		// Thread.sleep(sleepTimers);
	}

	@AfterAll
	public static void endTesting() throws Exception {
		Thread.sleep(sleepTimers);
		try {
			driver.close();
		} catch (Exception e) {
			System.err.println("The driver was closed Error." + e.getClass());
			// driver.switchTo().alert().accept();
		}
		System.out.println("\nEnd function: Sanity test - Trivia application\n");
	}
}