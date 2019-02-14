package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionCreationPage {
	private WebDriver driver;
	private WebElement[] QuestionCreationArr;

	// Constructor
	public QuestionCreationPage(WebDriver localDriver) {
		this.driver = localDriver;
	}

	// Use xpath in this page

	// Catch the elements on the Question Creation page
	public WebElement[] selectQuestionCreationPageElements(int size) throws Exception {
		this.QuestionCreationArr = new WebElement[size];
		try {
			// Head line of question
			if (!driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[0] = driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/legend"));
			}
			// Question
			if (!driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[1] = driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
			}
			// Head Line of answers
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/legend")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[2] = driver.findElement(By.xpath("//*[@id=\"answers\"]/legend"));
			}
			// Radio 1
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[3] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
			}
			// Radio 2
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[4] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input"));
			}
			// Radio 3
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[5] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
			}
			// Radio 4
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[1]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[6] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[1]/input"));
			}
			// Answer 1
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[7] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input"));
			}
			// Answer 2
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[8] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input"));
			}
			// Answer 3
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[9] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input"));
			}
			// Answer 4
			if (!driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[10] = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input"));
			}
			// Button next
			if (!driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).isEnabled()) {
				throw new Exception();
			} else {
				QuestionCreationArr[11] = driver.findElement(By.xpath("//*[@id=\"nextquest\"]"));
			}
			// Button back
			if (!driver.findElement(By.xpath("//*[@id=\"backquest\"]")).isEnabled()) { // .isDisplayed()) { // Temp bypass for known bug
				QuestionCreationArr[12] = driver.findElement(By.xpath("//*[@id=\"backquest\"]")); // Temp bypass for known bug
				throw new Exception();
			} else {
				QuestionCreationArr[12] = driver.findElement(By.xpath("//*[@id=\"backquest\"]"));
			}
		} catch (Exception e) {
			System.err.println("WebElement is unable at Question Creation Page Error." + e.getClass());
		}
		return QuestionCreationArr;
	}

}