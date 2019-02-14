package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {
	private WebDriver driver;
	private WebElement[] startBtn;

	// Constructor
	public StartPage(WebDriver localDriver) {
		this.driver = localDriver;
	}

	// Use id in this page

	// Catch the elements on the Start page
	public WebElement[] selectStartPageElement(int size) throws Exception {
		this.startBtn = new WebElement[size];
		try {
			// Button start
			if (!driver.findElement(By.id("startB")).isEnabled()) {
				throw new Exception();
			} else {
				startBtn[0] = driver.findElement(By.id("startB"));
			}
		} catch (Exception e) {
			System.err.println("WebElement is unable at Start Page Error." + e.getClass());
		}
		return startBtn;
	}
}