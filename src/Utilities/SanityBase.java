package Utilities;

import static org.junit.Assert.fail;

//import java.util.Arrays; //needed to print the answers array

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.EndTriviaPage;
import Pages.LetsPlayPage;
import Pages.QuestionCreationPage;
import Pages.StartPage;
import Pages.TriviaPage;
import Utilities.MethodsManager;

//Tests class
@DisplayName("Trivia Sanity Test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SanityBase extends MethodsManager {

	private StartPage testSite;
	private QuestionCreationPage testSite2;
	private LetsPlayPage testSite3;
	private TriviaPage testSite4;
	private EndTriviaPage testSite5;

	private WebElement[] StartPageElementArr;
	private WebElement[] QuestionCreationPageElementArr;
	private WebElement[] LetsPlayPageElementArr;
	private WebElement[] TriviaPageElementArr;
	private WebElement[] EndTriviaPageElementArr;

	//Constructor for default extends (don't need to get WebDriver)
	public SanityBase() throws Exception {
		this.testSite = new StartPage(driver);
		this.testSite2 = new QuestionCreationPage(driver);
		this.testSite3 = new LetsPlayPage(driver);
		this.testSite4 = new TriviaPage(driver);
		this.testSite5 = new EndTriviaPage(driver);
	}

	//Constructor for modified extends (need to get the modified WebDriver)
	public SanityBase(WebDriver driver) {
		this.testSite = new StartPage(driver);
		this.testSite2 = new QuestionCreationPage(driver);
		this.testSite3 = new LetsPlayPage(driver);
		this.testSite4 = new TriviaPage(driver);
		this.testSite5 = new EndTriviaPage(driver);
	}

	//Setters for WebElement Arrays
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

	@Test
	@DisplayName("1.0) Button is visible?")
	protected void aaaa() throws Exception {
		String num = "1.0";
		Thread.sleep(sleepTimers);
		try {
			setStartPageElementArr();
			MethodsManager.verifyElementIsVisible(StartPageElementArr, 0, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}
	
	@Test
	@DisplayName("1.1) Button text is Equal?")
	protected void aaab() throws Exception {
		String num = "1.1";
		String startBtn = "Start";
		Thread.sleep(sleepTimers);
		try {
			setStartPageElementArr();
			MethodsManager.verifyTextIsEqual(StartPageElementArr, 0, startBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.0) Text Is Equal?")
	protected void aaac() throws Exception {
		String num = "2.0";
		String questionHadline = "Please type here your question :" + "\n" + "question number: 1";
		Thread.sleep(sleepTimers);
		try {
			setStartPageElementArr();
			StartPageElementArr[0].click();
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.1) Button is Visible?")
	protected void aaad() throws Exception {
		String num = "2.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.2) Left button text Is Equal?")
	protected void aaae() throws Exception {
		String num = "2.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.3) Button is Visible?")
	protected void aaaf() throws Exception {
		String num = "2.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.4) Right button text Is Equal?")
	protected void aaag() throws Exception {
		String num = "2.4";
		String backBtn = "Back";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.5) Question box is available?")
	protected void aaah() throws Exception {
		String num = "2.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("2.6) Question input box Is empty?")
	protected void aaai() throws Exception {
		String num = "2.6";
		String questionOne = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("3.0) Question input box text is Equal?")
	protected void aaaj() throws Exception {
		String num = "3.0";
		String qauestionOne = questions[0];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[1].sendKeys(qauestionOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, qauestionOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.0) Text Is Equal?")
	protected void aaak() throws Exception {
		String num = "4.0";
		String answerHadline = "Please enter 4 possible answers and Mark the right one!" + "\n" + "question number: 1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 2, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.1) Left button is Visible?")
	protected void aaal() throws Exception {
		String num = "4.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.2) Left button text Is Equal?")
	protected void aaam() throws Exception {
		String num = "4.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.3) Right button is visible?")
	protected void aaan() throws Exception {
		String num = "4.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.4) Right button text Is Equal?")
	protected void aaao() throws Exception {
		String num = "4.4";
		String backBtn = "Back";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.5) First answer box is available?")
	protected void aaap() throws Exception {
		String num = "4.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 7, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.6) First answer box is empty?")
	protected void aaaq() throws Exception {
		String num = "4.6";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 7, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.7) Second answer box is available?")
	protected void aaar() throws Exception {
		String num = "4.7";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 8, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.8) Second answer box is empty?")
	protected void aaas() throws Exception {
		String num = "4.8";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 8, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.9) Third answer box is available?")
	protected void aaat() throws Exception {
		String num = "4.9";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 9, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.10) Third answer box is empty?")
	protected void aaau() throws Exception {
		String num = "4.10";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 9, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.11) Fourth answer box is available?")
	protected void aaav() throws Exception {
		String num = "4.11";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.12) Fourth answer box is empty?")
	protected void aaaw() throws Exception {
		String num = "4.12";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 10, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.13) First radio button Is Visible?")
	protected void aaax() throws Exception {
		String num = "4.13";
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.14) First radio button Is Not Selected?")
	protected void aaay() throws Exception {
		String num = "4.14";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.15) Second radio button Is Visible?")
	protected void aaaz() throws Exception {
		String num = "4.15";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 4, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.16) Second radio button Is Not Selected?")
	protected void aaba() throws Exception {
		String num = "4.16";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 4, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.17) Thrid radio button Is Visible?")
	protected void aabb() throws Exception {
		String num = "4.17";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 5, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.18) Thrid radio button Is Not Selected?")
	protected void aabc() throws Exception {
		String num = "4.18";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 5, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.19) Fourth radio button Is Visible?")
	protected void aabd() throws Exception {
		String num = "4.19";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 6, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("4.20) Fourth radio button Is Not Selected?")
	protected void aabe() throws Exception {
		String num = "4.20";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 6, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("5.0) First input box text is Equal?")
	protected void aabf() throws Exception {
		String num = "5.0";
		String answerOne = answers[0];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[7].sendKeys(answerOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, answerOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("6.0) Second input box text is Equal?")
	protected void aabg() throws Exception {
		String num = "6.0";
		String answerTwo = answers[1];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[8].sendKeys(answerTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, answerTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("7.0) Thrid input box text is Equal?")
	protected void aabh() throws Exception {
		String num = "7.0";
		String answerThree = answers[2];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[9].sendKeys(answerThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, answerThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("8.0) Fourth input box text is Equal?")
	protected void aabi() throws Exception {
		String num = "8.0";
		String answerFour = answers[3];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[10].sendKeys(answerFour);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, answerFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("9.0) First radio button Is selected?")
	protected void aabj() throws Exception {
		String num = "9.0";
		boolean radioOne = true;
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[3].click();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.0) Text Is Equal?")
	protected void aabk() throws Exception {
		String num = "10.0";
		String questionHadline = "Please type here your question :" + "\n" + "question number: 2";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.1) Btn is visible?")
	protected void aabl() throws Exception {
		String num = "10.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.2) Left button text Is Equal?")
	protected void aabm() throws Exception {
		String num = "10.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.3) Btn is visible?")
	protected void aabn() throws Exception {
		String num = "10.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.4) Right button text Is Equal?")
	protected void aabo() throws Exception {
		String num = "10.4";
		String backBtn = "Back";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.5) box is available?")
	protected void aabp() throws Exception {
		String num = "10.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("10.6) Question input box Is empty?")
	protected void aabq() throws Exception {
		String num = "10.6";
		String questionTwo = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("11.0) Question input box text is Equal?")
	protected void aabr() throws Exception {
		String num = "11.0";
		String qauestionTwo = questions[1];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[1].sendKeys(qauestionTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, qauestionTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.0) Text Is Equal?")
	protected void aabs() throws Exception {
		String num = "12.0";
		String answerHadline = "Please enter 4 possible answers and Mark the right one!" + "\n" + "question number: 2";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 2, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.1) Left button is visible?")
	protected void aabt() throws Exception {
		String num = "12.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.2) Left button text Is Equal?")
	protected void aabu() throws Exception {
		String num = "12.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.3) Right button is visible?")
	protected void aabv() throws Exception {
		String num = "12.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.4) Right button text Is Equal?")
	protected void aabw() throws Exception {
		String num = "12.4";
		String backBtn = "Back";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.5) First answer box is available?")
	protected void aabx() throws Exception {
		String num = "12.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 7, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.6) First answer box is empty?")
	protected void aaby() throws Exception {
		String num = "12.6";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 7, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.7) Second answer box is available?")
	protected void aabz() throws Exception {
		String num = "12.7";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 8, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.8) Second answer box is empty?")
	protected void aaca() throws Exception {
		String num = "12.8";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 8, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.9) Third answer box is available?")
	protected void aacb() throws Exception {
		String num = "12.9";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 9, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.10) Third answer box is empty?")
	protected void aacc() throws Exception {
		String num = "12.10";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 9, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.11) Fourth answer box is available?")
	protected void aacd() throws Exception {
		String num = "12.11";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.12) Fourth answer box is empty?")
	protected void aace() throws Exception {
		String num = "12.12";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 10, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.13) First radio button Is Visible?")
	protected void aacf() throws Exception {
		String num = "12.13";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.14) First radio button Is Not Selected?")
	protected void aacg() throws Exception {
		String num = "12.14";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.15) Second radio button Is Visible?")
	protected void aach() throws Exception {
		String num = "12.15";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 4, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.16) Second radio button Is Not Selected?")
	protected void aaci() throws Exception {
		String num = "12.16";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 4, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.17) Thrid radio button Is Visible?")
	protected void aacj() throws Exception {
		String num = "12.17";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 5, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.18) Thrid radio button Is Not Selected?")
	protected void aack() throws Exception {
		String num = "12.18";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 5, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.19) Fourth radio button Is Visible?")
	protected void aacl() throws Exception {
		String num = "12.19";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 6, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("12.20) Fourth radio button Is Not Selected?")
	protected void aacm() throws Exception {
		String num = "12.20";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 6, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("13.0) First input box text is Equal?")
	protected void aacn() throws Exception {
		String num = "13.0";
		String answerOne = answers[4];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[7].sendKeys(answerOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, answerOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("14.0) Second input box text is Equal?")
	protected void aaco() throws Exception {
		String num = "14.0";
		String answerTwo = answers[5];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[8].sendKeys(answerTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, answerTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("15.0) Thrid input box text is Equal?")
	protected void aacp() throws Exception {
		String num = "15.0";
		String answerThree = answers[6];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[9].sendKeys(answerThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, answerThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("16.0) Fourth input box text is Equal?")
	protected void aacq() throws Exception {
		String num = "16.0";
		String answerFour = answers[7];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[10].sendKeys(answerFour);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, answerFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("17.0) Second radio button Is selected?")
	protected void aacr() throws Exception {
		String num = "17.0";
		boolean radioOne = true;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[4].click();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 4, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.0) Text Is Equal?")
	protected void aacs() throws Exception {
		String num = "18.0";
		String questionHadline = "Please type here your question :" + "\n" + "question number: 3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 0, questionHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.1) Btn is visible?")
	protected void aact() throws Exception {
		String num = "18.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.2) Left button text Is Equal?")
	protected void aacu() throws Exception {
		String num = "18.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.3) Btn is visible?")
	protected void aacv() throws Exception {
		String num = "18.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.4) Right button text Is Equal?")
	protected void aacw() throws Exception {
		String num = "18.4";
		String backBtn = "Back";
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.5) box is available?")
	protected void aacx() throws Exception {
		String num = "18.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("18.6) Question input box Is empty?")
	protected void aacy() throws Exception {
		String num = "18.6";
		String questionThree = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, questionThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("19.0) Question input box text is Equal?")
	protected void aacz() throws Exception {
		String num = "19.0";
		String qauestionThree = questions[2];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[1].sendKeys(qauestionThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 1, qauestionThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.0) Text Is Equal?")
	protected void aada() throws Exception {
		String num = "20.0";
		String answerHadline = "Please enter 4 possible answers and Mark the right one!" + "\n" + "question number: 3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 2, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.1) Left button is visible?")
	protected void aadb() throws Exception {
		String num = "20.1";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.2) Left button text Is Equal?")
	protected void aadc() throws Exception {
		String num = "20.2";
		String nextBtn = "Next";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 11, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.3) Right button is visible?")
	protected void aade() throws Exception {
		String num = "20.3";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 12, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.4) Right button text Is Equal?")
	protected void aadf() throws Exception {
		String num = "20.4";
		String backBtn = "Back";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 12, backBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.5) First answer box is available?")
	protected void aadg() throws Exception {
		String num = "20.5";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 7, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.6) First answer box is empty?")
	protected void aadh() throws Exception {
		String num = "20.6";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 7, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.7) Second answer box is available?")
	protected void aadi() throws Exception {
		String num = "20.7";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 8, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.8) Second answer box is empty?")
	protected void aadj() throws Exception {
		String num = "20.8";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 8, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.9) Third answer box is available?")
	protected void aadk() throws Exception {
		String num = "20.9";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 9, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.10) Third answer box is empty?")
	protected void aadl() throws Exception {
		String num = "20.10";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 9, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.11) Fourth answer box is available?")
	protected void aadm() throws Exception {
		String num = "20.11";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsAvailable(QuestionCreationPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.12) Fourth answer box is empty?")
	protected void aadn() throws Exception {
		String num = "20.12";
		String answerBox = "";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyTextIsEqual(QuestionCreationPageElementArr, 10, answerBox, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not available: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.13) First radio button Is Visible?")
	protected void aado() throws Exception {
		String num = "20.13";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 3, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.14) First radio button Is Not Selected?")
	protected void aadp() throws Exception {
		String num = "20.14";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 3, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.15) Second radio button Is Visible?")
	protected void aadq() throws Exception {
		String num = "20.15";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 4, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.16) Second radio button Is Not Selected?")
	protected void aadr() throws Exception {
		String num = "20.16";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 4, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.17) Thrid radio button Is Visible?")
	protected void aads() throws Exception {
		String num = "20.17";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 5, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.18) Thrid radio button Is Not Selected?")
	protected void aadt() throws Exception {
		String num = "20.18";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 5, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.19) Fourth radio button Is Visible?")
	protected void aadu() throws Exception {
		String num = "20.19";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyElementIsVisible(QuestionCreationPageElementArr, 6, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("20.20) Fourth radio button Is Not Selected?")
	protected void aadv() throws Exception {
		String num = "20.20";
		boolean radioOne = false;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 6, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("21.0) First input box text is Equal?")
	protected void aadw() throws Exception {
		String num = "21.0";
		String answerOne = answers[8];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[7].sendKeys(answerOne);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 7, answerOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("22.0) Second input box text is Equal?")
	protected void aadx() throws Exception {
		String num = "22.0";
		String answerTwo = answers[9];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[8].sendKeys(answerTwo);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 8, answerTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("23.0) Thrid input box text is Equal?")
	protected void aady() throws Exception {
		String num = "23.0";
		String answerThree = answers[10];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[9].sendKeys(answerThree);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 9, answerThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("24.0) Fourth input box text is Equal?")
	protected void aadz() throws Exception {
		String num = "24.0";
		String answerFour = answers[11];
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[10].sendKeys(answerFour);
			MethodsManager.verifyTextInputIsEqual(QuestionCreationPageElementArr, 10, answerFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Input text: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("25.0) Thrid radio button Is selected?")
	protected void aaea() throws Exception {
		String num = "25.0";
		boolean radioOne = true;
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[5].click();
			MethodsManager.verifyRadioButtonCondition(QuestionCreationPageElementArr, 5, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("26.0) Text Is Equal?")
	protected void aaeb() throws Exception {
		String num = "26.0";
		String letsPlayHadline = "You finished to build the test - lets play!!";
		Thread.sleep(sleepTimers);
		try {
			setQuestionCreationPageElementArr();
			QuestionCreationPageElementArr[11].click();
			setLetsPlayPageElementArr();
			MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 0, letsPlayHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("26.1) Btn is visible?")
	protected void aaec() throws Exception {
		String num = "26.1";
		Thread.sleep(sleepTimers);
		try {
			setLetsPlayPageElementArr();
			MethodsManager.verifyElementIsVisible(LetsPlayPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("26.2) Left button text Is Equal?")
	protected void aaed() throws Exception {
		String num = "26.2";
		String nextBtn = "Play";
		Thread.sleep(sleepTimers);
		try {
			setLetsPlayPageElementArr();
			MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 1, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("26.3) Btn is visible?")
	protected void aaee() throws Exception {
		String num = "26.3";
		Thread.sleep(sleepTimers);
		try {
			setLetsPlayPageElementArr();
			MethodsManager.verifyElementIsVisible(LetsPlayPageElementArr, 2, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("26.4) Left button text Is Equal?")
	protected void aaef() throws Exception {
		String num = "26.4";
		String nextBtn = "Quit";
		Thread.sleep(sleepTimers);
		try {
			setLetsPlayPageElementArr();
			MethodsManager.verifyTextIsEqual(LetsPlayPageElementArr, 2, nextBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.0) Text Is Equal?")
	protected void aaeg() throws Exception {
		String num = "27.0";
		String answerHadline = "Test";
		Thread.sleep(sleepTimers);
		try {
			setLetsPlayPageElementArr();
			LetsPlayPageElementArr[1].click();
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 0, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.1) Text Is Equal?")
	protected void aaeh() throws Exception {
		String num = "27.1";
		String[] questionArr = questionsInTrivia;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, questionArr, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		} finally {
			System.out.println("The first question is: " + questionIs);
		}
	}

	@Test
	@DisplayName("27.2) Question Mark Is visible?")
	protected void aaei() throws Exception {
		String num = "27.2";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyQuestionMark(TriviaPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.3 ) First radio button Is Not Selected?")
	protected void aaej() throws Exception {
		boolean radioOne = false;
		String num = "27.3";
		int btnNum = 2;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.4 ) Second radio button Is Not Selected?")
	protected void aaek() throws Exception {
		boolean radioTwo = false;
		String num = "27.4";
		int btnNum = 3;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.5 ) Thrid radio button Is Not Selected?")
	protected void aael() throws Exception {
		boolean radioThree = false;
		String num = "27.5";
		int btnNum = 4;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.6 ) Fourth radio button Is Not Selected?")
	protected void aaem() throws Exception {
		boolean radioFour = false;
		String num = "27.6";
		int btnNum = 5;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.7) First answer Text is Equal?")
	protected void aaen() throws Exception {
		String num = "27.7";
		int answerNum = 1;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.8) Second answer Text is Equal?")
	protected void aaeo() throws Exception {
		String num = "27.8";
		int answerNum = 2;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.9) Third answer Text is Equal?")
	protected void aaep() throws Exception {
		String num = "27.9";
		int answerNum = 3;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.10) Fourth answer Text is Equal?")
	protected void aaeq() throws Exception {
		String num = "27.10";
		int answerNum = 4;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.11) Left button is visible?")
	protected void aaer() throws Exception {
		String num = "27.11";
		Thread.sleep(sleepTimers);
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.12) Left button text Is Equal?")
	protected void aaes() throws Exception {
		String num = "27.12";
		String leftBtn = "Next!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 10, leftBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.13) Rihght button is visible?")
	protected void aaet() throws Exception {
		String num = "27.13";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("27.14) Right button text Is Equal?")
	protected void aaeu() throws Exception {
		String num = "27.14";
		String rightBtn = "Back!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 11, rightBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("28.0) The right answer radio button Is selected?")
	protected void aaev() throws Exception {
		String num = "28.0";
		boolean radioRight = true;
		String questionIs = "";
		String[][] answerLine = new String[4][4];
		int rightAnswer = 0;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			answerLine = getAnswer(questionIs, num);
			// System.out.println(Arrays.deepToString(answerLine));
			// for printing all the answers array from getAnswer method
			for (int i = 0; i < 4; i++) {
				if (answerLine[i][1].equals("1")) {
					rightAnswer = i;
					break;
				}
			}
			TriviaPageElementArr[rightAnswer + 2].click();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, rightAnswer + 2, radioRight, num);
		} catch (Exception e) {
			System.err.println(num + ") No right answer was found, chose the first one as default: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.0) Text Is Equal?")
	protected void aaew() throws Exception {
		String num = "29.0";
		String answerHadline = "Test";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			TriviaPageElementArr[10].click();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 0, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.1) Text Is Equal?")
	protected void aaex() throws Exception {
		String num = "29.1";
		String[] questionArr = questionsInTrivia;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, questionArr, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		} finally {
			System.out.println("The Second question is: " + questionIs);
		}
	}

	@Test
	@DisplayName("29.2) Question Mark Is visible?")
	protected void aaey() throws Exception {
		String num = "29.2";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyQuestionMark(TriviaPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.3 ) First radio button Is Not Selected?")
	protected void aaez() throws Exception {
		boolean radioOne = false;
		String num = "29.3";
		int btnNum = 2;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.4 ) Second radio button Is Not Selected?")
	protected void aafa() throws Exception {
		boolean radioTwo = false;
		String num = "29.4";
		int btnNum = 3;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.5 ) Thrid radio button Is Not Selected?")
	protected void aafb() throws Exception {
		boolean radioThree = false;
		String num = "29.5";
		int btnNum = 4;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.6 ) Fourth radio button Is Not Selected?")
	protected void aafc() throws Exception {
		boolean radioFour = false;
		String num = "29.6";
		int btnNum = 5;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.7) First answer Text is Equal?")
	protected void aafd() throws Exception {
		String num = "29.7";
		int answerNum = 1;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.8) Second answer Text is Equal?")
	protected void aafe() throws Exception {
		String num = "29.8";
		int answerNum = 2;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.9) Third answer Text is Equal?")
	protected void aaff() throws Exception {
		String num = "29.9";
		int answerNum = 3;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.10) Fourth answer Text is Equal?")
	protected void aafg() throws Exception {
		String num = "29.10";
		int answerNum = 4;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.11) Left button is visible?")
	protected void aafh() throws Exception {
		String num = "29.11";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.12) Left button text Is Equal?")
	protected void aafi() throws Exception {
		String num = "29.12";
		String leftBtn = "Next!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 10, leftBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.13) Rihght button is visible?")
	protected void aafj() throws Exception {
		String num = "29.13";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("29.14) Right button text Is Equal?")
	protected void aafk() throws Exception {
		String num = "29.14";
		String rightBtn = "Back!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 11, rightBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("30.0) The right answer radio button Is selected?")
	protected void aafl() throws Exception {
		String num = "30.0";
		boolean radioRight = true;
		String questionIs = "";
		String[][] answerLine = new String[4][4];
		int rightAnswer = 0;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			answerLine = getAnswer(questionIs, num);
			// System.out.println(Arrays.deepToString(answerLine));
			// for printing all the answers array from getAnswer method
			for (int i = 0; i < 4; i++) {
				if (answerLine[i][1].equals("1")) {
					rightAnswer = i;
					break;
				}
			}
			TriviaPageElementArr[rightAnswer + 2].click();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, rightAnswer + 2, radioRight, num);
		} catch (Exception e) {
			System.err.println(num + ") No right answer was found, chose the first one as default: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.0) Text Is Equal?")
	protected void aafm() throws Exception {
		String num = "31.0";
		String answerHadline = "Test";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			TriviaPageElementArr[10].click();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 0, answerHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.1) Text Is Equal?")
	protected void aafn() throws Exception {
		String num = "31.1";
		String[] questionArr = questionsInTrivia;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			MethodsManager.verifyTextIsEqualArr(TriviaPageElementArr, 1, questionArr, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		} finally {
			System.out.println("The third question is: " + questionIs);
		}
	}

	@Test
	@DisplayName("31.2) Question Mark Is visible?")
	protected void aafo() throws Exception {
		String num = "31.2";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyQuestionMark(TriviaPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.3 ) First radio button Is Not Selected?")
	protected void aafp() throws Exception {
		boolean radioOne = false;
		String num = "31.3";
		int btnNum = 2;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioOne, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.4 ) Second radio button Is Not Selected?")
	protected void aafq() throws Exception {
		boolean radioTwo = false;
		String num = "31.4";
		int btnNum = 3;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioTwo, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.5 ) Thrid radio button Is Not Selected?")
	protected void aafr() throws Exception {
		boolean radioThree = false;
		String num = "31.5";
		int btnNum = 4;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioThree, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.6 ) Fourth radio button Is Not Selected?")
	protected void aafs() throws Exception {
		boolean radioFour = false;
		String num = "31.6";
		int btnNum = 5;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, btnNum, radioFour, num);
		} catch (Exception e) {
			System.err.println(num + ") Radio button: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.7) First answer Text is Equal?")
	protected void aaft() throws Exception {
		String num = "31.7";
		int answerNum = 1;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.8) Second answer Text is Equal?")
	protected void aafu() throws Exception {
		String num = "31.8";
		int answerNum = 2;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.9) Third answer Text is Equal?")
	protected void aafv() throws Exception {
		String num = "31.9";
		int answerNum = 3;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.10) Fourth answer Text is Equal?")
	protected void aafw() throws Exception {
		String num = "31.10";
		int answerNum = 4;
		String questionIs = "";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			String[][] answerLine = getAnswer(questionIs, num);
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, answerNum + 5, answerLine[answerNum - 1][0], num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.11) Left button is visible?")
	protected void aafx() throws Exception {
		String num = "31.11";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 10, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.12) Left button text Is Equal?")
	protected void aafy() throws Exception {
		String num = "31.12";
		String leftBtn = "Next!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 10, leftBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.13) Rihght button is Equal?")
	protected void aafz() throws Exception {
		String num = "31.13";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(TriviaPageElementArr, 11, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("31.14) Right button text Is Equal?")
	protected void aaga() throws Exception {
		String num = "31.14";
		String rightBtn = "Back!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(TriviaPageElementArr, 11, rightBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("32.0) The right answer radio button Is selected?")
	protected void aagb() throws Exception {
		String num = "32.0";
		boolean radioRight = true;
		String questionIs = "";
		String[][] answerLine = new String[4][4];
		int rightAnswer = 0;
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			questionIs = TriviaPageElementArr[1].getText();
			answerLine = getAnswer(questionIs, num);
			// System.out.println(Arrays.deepToString(answerLine));
			// for printing all the answers array from getAnswer method
			for (int i = 0; i < 4; i++) {
				if (answerLine[i][1].equals("1")) {
					rightAnswer = i;
					break;
				}
			}
			TriviaPageElementArr[rightAnswer + 2].click();
			MethodsManager.verifyRadioButtonCondition(TriviaPageElementArr, rightAnswer + 2, radioRight, num);
		} catch (Exception e) {
			System.err.println(num + ") No right answer was found, chose the first one as default: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.0) Text Is Equal?")
	protected void aagc() throws Exception {
		String num = "33.0";
		String endHadline = "Success!!";
		Thread.sleep(sleepTimers);
		try {
			setTriviaPageElementArr();
			TriviaPageElementArr[10].click();
			setEndTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 0, endHadline, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.1) Left button is visible?")
	protected void aagd() throws Exception {
		String num = "33.1";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(EndTriviaPageElementArr, 2, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.2) Left button text Is Equal?")
	protected void aage() throws Exception {
		String num = "33.2";
		String leftBtn = "Try Again";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 2, leftBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.3) Rihght button is visible?")
	protected void aagf() throws Exception {
		String num = "33.3";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(EndTriviaPageElementArr, 3, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.4) Right button text Is Equal?")
	protected void aagg() throws Exception {
		String num = "33.4";
		String rightBtn = "Quit";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			MethodsManager.verifyTextIsEqual(EndTriviaPageElementArr, 3, rightBtn, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("33.5) Button is visible?")
	protected void aagh() throws Exception {
		String num = "33.5";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			MethodsManager.verifyElementIsVisible(EndTriviaPageElementArr, 1, num);
		} catch (Exception e) {
			System.err.println(num + ") Element is not visible: Error." + e.getClass());
			throw new Exception("Error");
		}
	}

	@Test
	@DisplayName("34.0) Triva app is closed?")
	protected void aagi() throws Exception {
		String num = "34.0";
		Thread.sleep(sleepTimers);
		try {
			setEndTriviaPageElementArr();
			EndTriviaPageElementArr[3].click();
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
}