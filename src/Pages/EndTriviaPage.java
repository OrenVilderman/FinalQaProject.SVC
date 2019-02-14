package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EndTriviaPage {
	private WebDriver driver;

	private WebElement[] EndTriviaPageArr;

	// Constructor
	public EndTriviaPage(WebDriver localDriver) {
		this.driver = localDriver;
	}

	// Use Attribute + value in cssSelector to find elements (dealing with value
	// that have two different values),
	// and Class in cssSelector to find elements.

	// Use list to find elements into List,
	// and get the elements out of the List,

	// Catch the elements on the End Trivia page
	public WebElement[] selectEndTriviaPageElement(int size) throws Exception {
		this.EndTriviaPageArr = new WebElement[size];
		try {
			// Trivia result
			try {
				if (driver.findElement(By.cssSelector("[style='border: 2px solid; color: green; background-color: lightgreen;']")).isEnabled()) {
					EndTriviaPageArr[0] = driver.findElement(By.cssSelector("[style='border: 2px solid; color: green; background-color: lightgreen;']"));
				}
			} catch (NoSuchElementException e) {
				if (driver.findElement(By.cssSelector("[style='border: 2px solid; color: red; background-color: tomato;']")).isEnabled()) {
					EndTriviaPageArr[0] = driver.findElement(By.cssSelector("[style='border: 2px solid; color: red; background-color: tomato;']"));
				}
			}

			// Share on FB
			if (!driver.findElement(By.cssSelector("[style='opacity: 1;']")).isEnabled()) {
				throw new Exception();
			} else {
				EndTriviaPageArr[1] = driver.findElement(By.cssSelector("[style='opacity: 1;']"));
			}

			// Again button
			List<WebElement> list = driver.findElements(By.cssSelector(".w3-btn.w3-round-xlarge.w3-hover-purple.w3-khaki.w3-padding-large.playCB"));
			list.get(2).isEnabled();
			if (!list.get(2).isEnabled()) {
				throw new Exception();
			} else {
				EndTriviaPageArr[2] = list.get(2);
			}

			// Quit button
			list.get(3).isEnabled();
			if (!list.get(3).isEnabled()) {
				throw new Exception();
			} else {
				EndTriviaPageArr[3] = list.get(3);
			}
		} catch (

		Exception e) {
			System.err.println("WebElement is unable at End Trivia Page Error." + e.getClass());
		}
		return EndTriviaPageArr;
	}
}