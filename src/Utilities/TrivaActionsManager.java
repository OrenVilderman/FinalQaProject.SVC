package Utilities;

import org.openqa.selenium.WebElement;

import Utilities.MethodsManager;

public class TrivaActionsManager extends MethodsManager {
	
	public static void fillQuestion(WebElement[] StartPageElementArr, WebElement[] QuestionCreationPageElementArr, String question) throws Exception {
		try {
			StartPageElementArr[0].click();
		} catch (Exception e) {
			QuestionCreationPageElementArr[11].click();
		}
		QuestionCreationPageElementArr[1].sendKeys(question);
	}

	public static void fillAnswers(WebElement[] QuestionCreationPageElementArr, String[] answers) throws Exception {
		QuestionCreationPageElementArr[7].sendKeys(answers[0]);
		QuestionCreationPageElementArr[8].sendKeys(answers[1]);
		QuestionCreationPageElementArr[9].sendKeys(answers[2]);
		QuestionCreationPageElementArr[10].sendKeys(answers[3]);
	}

	public static void goToTrivia(WebElement[] QuestionCreationPageElementArr, WebElement[] LetsPlayPageElementArr) throws Exception {
		QuestionCreationPageElementArr[11].click();
		LetsPlayPageElementArr[1].click();
	}

	public static void selectAnswer(WebElement[] TriviaPageElementArr, int rightAnswer) throws Exception {
		TriviaPageElementArr[rightAnswer + 2].click();
		TriviaPageElementArr[10].click();
	}

	// this will select the right answer only if the question is right
	public static void selectRightAnswer(WebElement[] TriviaPageElementArr, String num) throws Exception {
		String questionIs = "";
		String[][] answerLine = new String[4][4];
		int rightAnswer = 0;
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
		TriviaPageElementArr[10].click();
	}

	public static void letsPlay(WebElement[] StartPageElementArr, WebElement[] QuestionCreationPageElementArr, WebElement[] LetsPlayPageElementArr, WebElement[] TriviaPageElementArr,
			String[] questions, String[] answers) throws Exception {
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
		LetsPlayPageElementArr[1].click();
	}

	public static void fastPlay(WebElement[] StartPageElementArr, WebElement[] QuestionCreationPageElementArr, WebElement[] LetsPlayPageElementArr, WebElement[] TriviaPageElementArr,
			String[] questions, String[] answers, String num) throws Exception {
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
		LetsPlayPageElementArr[1].click();
		TriviaPageElementArr = Tests.TriviaFunctionalityTest.NewTriviaPageElementArr();
		selectRightAnswer(TriviaPageElementArr, num);
		TriviaPageElementArr = Tests.TriviaFunctionalityTest.NewTriviaPageElementArr();
		selectRightAnswer(TriviaPageElementArr, num);
		TriviaPageElementArr = Tests.TriviaFunctionalityTest.NewTriviaPageElementArr();
		selectRightAnswer(TriviaPageElementArr, num);
	}
}