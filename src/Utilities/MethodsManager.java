package Utilities;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MethodsManager {

	protected static WebDriver driver;
	protected static int sleepTimers = 0; // 200; --> this should be used only for visual inspecting of the test 100 =
											// about 60 seconds in total (for sanity).
	// public static int necessarySleepTimers = 0; //300; --> There are no necessary sleep timers for loading
	protected static String url = "https://svcollegetest.000webhostapp.com/";
	// Local bugged version <-- for faster test time
	protected static String urlAlt = "file:/C:/Users/Real Bob/svc/FinalProject.SVC/SVC final project files/svcTest.html";
	// Local Fixed version <-- to test the test program itself
	protected static String urlFixed = "file:/C:/Users/Real Bob/svc/FinalProject.SVC/SVC final project files/svcFixedTest.html";

	// Questions and Answers
	protected static String[] questions = { "a", "b", "c" };
	protected static String[] questionsInTrivia = { "a?", "b?", "c?" };
	protected static String[] answers = { "a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d" };
	protected static int[] rightanswers = { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }; // Mark the right answers with 1 and 0 for wrong answers

	protected static int testsCounter = 0;

	public static void choserChromeDriver() {
		// url = urlFixed;
		// url = urlAlt;
		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("window-size=900,850");
		driver = new ChromeDriver(options);
		driver.manage().window().setPosition(new Point(600, 10));
	}

	public static WebDriver choserFireFoxDriver() {
		// url = urlFixed;
		// url = urlAlt;
		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(900, 800));
		driver.manage().window().setPosition(new Point(600, 10));
		return driver;
	}

	public static WebDriver choserInternetExplorerDriver() {
		// This can be used to run sanity on all 3 servers of the site <-- this is
		// needed to short the tests time by approximately 50%
		if (testsCounter == 1) {
			// url = urlAlt;
		} else if (testsCounter > 1) {
			// url = urlFixed;
		}
		// testsCounter++;
		// url = urlFixed;
		// url = urlAlt;
		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		driver = new InternetExplorerDriver();
		driver.manage().window().setSize(new Dimension(900, 800));
		driver.manage().window().setPosition(new Point(600, 10));
		return driver;
	}

	// Verify Element is Visible
	public static void verifyElementIsVisible(WebElement[] element, int count, String number) throws Exception {
		try {
			if (element[count].isDisplayed()) {
				System.out.println(number + ") WebElement Is visible.");
			} else {
				System.out.print("\n" + number + ") WebElement Is NOT visible.");
				System.out.println(" @failure\n");
				fail();
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	// Verify Text is Equal
	public static void verifyTextIsEqual(WebElement[] element, int count, String text, String number) throws Exception {
		try {
			assertEquals(text, element[count].getText());
			if (text.length() > 0) {
				System.out.println(number + ") Text Is Equal.");
			} else {
				System.out.println(number + ") Text Is Empty.");
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		} catch (AssertionError e) {
			if (text.length() > 0) {
				System.out.print("\n" + number + ") Text Is NOT Equal.");
				System.out.println(" @failure\n");
				fail(e);
			} else {
				System.out.print("\n" + number + ") Text Is NOT Empty.");
				System.out.println(" @failure\n");
				fail(e);
			}
		}
	}

	// Verify Input is Equal
	public static void verifyTextInputIsEqual(WebElement[] element, int count, String text, String number) throws Exception {
		try {
			assertEquals(text, element[count].getAttribute("value"));
			if (text.length() > 0) {
				System.out.println(number + ") Input Text Is Equal.");
			} else {
				System.out.println(number + ") Input Text Is Empty.");
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		} catch (AssertionError e) {
			if (text.length() > 0) {
				System.out.print("\n" + number + ") Input Text Is NOT Equal.");
				System.out.println(" @failure\n");
				fail(e);
			} else {
				System.out.print("\n" + number + ") Input Text Is NOT Empty.");
				System.out.println(" @failure\n");
				fail(e);
			}
		}
	}

	// Verify Input is Equal to Arr
	public static void verifyTextIsEqualArr(WebElement[] element, int count, String[] textArr, String number) throws Exception {
		boolean expectedQuestion = false;
		try {
			for (int i = 0; i < textArr.length; i++) {
				if (element[count].getText().equals(textArr[i])) {
					System.out.println(number + ") Question Text Is Equal.");
					expectedQuestion = true;
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		}
		if (!expectedQuestion) {
			System.out.print("\n" + number + ") Question Text Is NOT Equal.");
			System.out.println(" @failure\n");
			fail();
		}
	}

	// Verify Input is present
	public static void verifyQuestionMark(WebElement[] element, int count, String number) throws Exception {
		try {
			assertEquals('?', element[count].getText().charAt(element[count].getText().length() - 1));
			System.out.println(number + ") Question mark is present.");
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		} catch (AssertionError e) {
			System.out.print("\n" + number + ") Question mark is NOT present.");
			System.out.println(" @failure\n");
			fail(e);
		}
	}

	// Verify radio button condition
	public static void verifyRadioButtonCondition(WebElement[] element, int count, boolean checked, String number) throws Exception {
		try {
			if (checked) {
				assertEquals(checked, element[count].isSelected()); // .getAttribute("checked"));
				System.out.println(number + ") Radio button is selected.");
			} else {
				assertEquals(checked, element[count].isSelected()); // .getAttribute("checked"));
				System.out.println(number + ") Radio button is NOT selected.");
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		} catch (AssertionError e) {
			if (checked) {
				System.out.print("\n" + number + ") Radio button is NOT selected.");
				System.out.println(" @failure\n");
				fail(e);
			} else {
				System.out.print("\n" + number + ") Radio button is selected.");
				System.out.println(" @failure\n");
				fail(e);
			}
		}
	}

	// Verify Element is Available
	public static void verifyElementIsAvailable(WebElement[] element, int count, String number) throws Exception {
		try {
			if (element[count].isEnabled()) {
				System.out.println(number + ") WebElement Is Available.");
			} else {
				System.out.print("\n" + number + ") WebElement Is NOT Available.");
				System.out.println(" @failure\n");
				fail();
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	// Provide the right answer to a question
	public static String[][] getAnswer(String questionIs, String number) throws Exception {
		int questionNum = 0;
		String[][] answerArr = new String[4][2];
		try {
			// here i look for the right answer, or the right answer with question mark
			if (questionIs.equals(questions[0]) || questionIs.equals(questionsInTrivia[0])) {
				questionNum = 1;
			} else if (questionIs.equals(questions[1]) || questionIs.equals(questionsInTrivia[1])) {
				questionNum = 2;
			} else {
				questionNum = 3;
			}
			switch (questionNum) {
			case 1:
				answerArr[0][0] = answers[0];
				answerArr[0][1] = Integer.toString(rightanswers[0]);
				answerArr[1][0] = answers[1];
				answerArr[1][1] = Integer.toString(rightanswers[1]);
				answerArr[2][0] = answers[2];
				answerArr[2][1] = Integer.toString(rightanswers[2]);
				answerArr[3][0] = answers[3];
				answerArr[3][1] = Integer.toString(rightanswers[3]);
				break;
			case 2:
				answerArr[0][0] = answers[4];
				answerArr[0][1] = Integer.toString(rightanswers[4]);
				answerArr[1][0] = answers[5];
				answerArr[1][1] = Integer.toString(rightanswers[5]);
				answerArr[2][0] = answers[6];
				answerArr[2][1] = Integer.toString(rightanswers[6]);
				answerArr[3][0] = answers[7];
				answerArr[3][1] = Integer.toString(rightanswers[7]);
				break;
			case 3:
				answerArr[0][0] = answers[8];
				answerArr[0][1] = Integer.toString(rightanswers[8]);
				answerArr[1][0] = answers[9];
				answerArr[1][1] = Integer.toString(rightanswers[9]);
				answerArr[2][0] = answers[10];
				answerArr[2][1] = Integer.toString(rightanswers[10]);
				answerArr[3][0] = answers[11];
				answerArr[3][1] = Integer.toString(rightanswers[11]);
				break;
			default:
				System.out.print("\n" + number + ") No right question was found .");
				System.out.println(" @failure\n");
				fail();
			}
		} catch (Exception e) {
			System.err.println("Method Error at Methods Manager page Error." + e.getClass());
			throw new Exception("Error");
		}
		return answerArr;
	}
}
