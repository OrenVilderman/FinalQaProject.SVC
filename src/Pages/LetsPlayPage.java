package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetsPlayPage {
	private WebDriver driver;
	private WebElement[] LetsPlayArr;

	// Constructor
	public LetsPlayPage(WebDriver localDriver) {
		this.driver = localDriver;
	}

	// Use cssSelector in this page

	// Catch the elements on the Lets Play page
	public WebElement[] selectLetsPlayPageElement(int size) throws Exception {
		this.LetsPlayArr = new WebElement[size];
		try {
			// Head line of Lets play
			if (!driver.findElement(By.cssSelector("#needBackGround")).isEnabled()) {
				throw new Exception();
			} else {
				LetsPlayArr[0] = driver.findElement(By.cssSelector("#needBackGround"));
			}
			// Left button of Lets play
			if (!driver.findElement(By.cssSelector("#secondepage > center > button:nth-child(2)")).isEnabled()) {
				throw new Exception();
			} else {
				LetsPlayArr[1] = driver.findElement(By.cssSelector("#secondepage > center > button:nth-child(2)"));
			}
			// Right button of Lets play
			if (!driver.findElement(By.cssSelector("#secondepage > center > button:nth-child(3)")).isEnabled()) {
				throw new Exception();
			} else {
				LetsPlayArr[2] = driver.findElement(By.cssSelector("#secondepage > center > button:nth-child(3)"));
			}
		} catch (Exception e) {
			System.err.println("WebElement is unable at Lets Play Page Error." + e.getClass());
		}
		return LetsPlayArr;
	}
}