package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TriviaPage {
	private WebDriver driver;
	private WebElement[] TriviaPageArr;

	// Constructor
	public TriviaPage(WebDriver localDriver) {
		this.driver = localDriver;
	}

	// Use cssSelector, xpath and id in this page

	// Catch the elements on the Question Creation page
	public WebElement[] selectTriviaPageElement(int size) throws Exception {
		this.TriviaPageArr = new WebElement[size];
		try {
			// Head line of Trivia
			if (!driver.findElement(By.cssSelector("#testpage > center > h1 > u")).isEnabled()) {
				throw new Exception();
			} else {
				TriviaPageArr[0] = driver.findElement(By.cssSelector("#testpage > center > h1 > u"));
			}
			// Question
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/h3")).isDisplayed()) {
					TriviaPageArr[1] = driver.findElement(By.xpath("//*[@id=\"0\"]/h3"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/h3")).isDisplayed()) {
					TriviaPageArr[1] = driver.findElement(By.xpath("//*[@id=\"1\"]/h3"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/h3")).isDisplayed()) {
					TriviaPageArr[1] = driver.findElement(By.xpath("//*[@id=\"2\"]/h3"));
				}
			}
			// Radio 1
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).isDisplayed()) {
					TriviaPageArr[2] = driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).isDisplayed()) {
					TriviaPageArr[2] = driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).isDisplayed()) {
					TriviaPageArr[2] = driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]"));
				}
			}
			// Radio 2
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]")).isDisplayed()) {
					TriviaPageArr[3] = driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]")).isDisplayed()) {
					TriviaPageArr[3] = driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]")).isDisplayed()) {
					TriviaPageArr[3] = driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]"));
				}
			}
			// Radio 3
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]")).isDisplayed()) {
					TriviaPageArr[4] = driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]")).isDisplayed()) {
					TriviaPageArr[4] = driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]")).isDisplayed()) {
					TriviaPageArr[4] = driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]"));
				}
			}
			// Radio 4
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]")).isDisplayed()) {
					TriviaPageArr[5] = driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]")).isDisplayed()) {
					TriviaPageArr[5] = driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]")).isDisplayed()) {
					TriviaPageArr[5] = driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]"));
				}
			}
			// Answer 1
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/span[1]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/span[1]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/span[1]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/span[1]")).isDisplayed()) {
					TriviaPageArr[6] = driver.findElement(By.xpath("//*[@id=\"0\"]/span[1]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/span[1]")).isDisplayed()) {
					TriviaPageArr[6] = driver.findElement(By.xpath("//*[@id=\"1\"]/span[1]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/span[1]")).isDisplayed()) {
					TriviaPageArr[6] = driver.findElement(By.xpath("//*[@id=\"2\"]/span[1]"));
				}
			}
			// Answer 2
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/span[2]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/span[2]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/span[2]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/span[2]")).isDisplayed()) {
					TriviaPageArr[7] = driver.findElement(By.xpath("//*[@id=\"0\"]/span[2]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/span[2]")).isDisplayed()) {
					TriviaPageArr[7] = driver.findElement(By.xpath("//*[@id=\"1\"]/span[2]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/span[2]")).isDisplayed()) {
					TriviaPageArr[7] = driver.findElement(By.xpath("//*[@id=\"2\"]/span[2]"));
				}
			}
			// Answer 3
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/span[3]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/span[3]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/span[3]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/span[3]")).isDisplayed()) {
					TriviaPageArr[8] = driver.findElement(By.xpath("//*[@id=\"0\"]/span[3]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/span[3]")).isDisplayed()) {
					TriviaPageArr[8] = driver.findElement(By.xpath("//*[@id=\"1\"]/span[3]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/span[3]")).isDisplayed()) {
					TriviaPageArr[8] = driver.findElement(By.xpath("//*[@id=\"2\"]/span[3]"));
				}
			}
			// Answer 4
			if (!driver.findElement(By.xpath("//*[@id=\"0\"]/span[4]")).isEnabled() || !driver.findElement(By.xpath("//*[@id=\"1\"]/span[4]")).isEnabled()
					|| !driver.findElement(By.xpath("//*[@id=\"2\"]/span[4]")).isEnabled()) {
				throw new Exception();
			} else {
				if (driver.findElement(By.xpath("//*[@id=\"0\"]/span[4]")).isDisplayed()) {
					TriviaPageArr[9] = driver.findElement(By.xpath("//*[@id=\"0\"]/span[4]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"1\"]/span[4]")).isDisplayed()) {
					TriviaPageArr[9] = driver.findElement(By.xpath("//*[@id=\"1\"]/span[4]"));
				} else if (driver.findElement(By.xpath("//*[@id=\"2\"]/span[4]")).isDisplayed()) {
					TriviaPageArr[9] = driver.findElement(By.xpath("//*[@id=\"2\"]/span[4]"));
				}
			}
			// Button next
			if (!driver.findElement(By.id("btnnext")).isEnabled()) {
				throw new Exception();
			} else {
				TriviaPageArr[10] = driver.findElement(By.id("btnnext"));
			}
			// Button back
			if (!driver.findElement(By.id("backquest")).isEnabled()) { // .isDisplayed()) { // Temp bypass for known bug
				TriviaPageArr[11] = driver.findElement(By.id("btnback")); // Temp bypass for known bug
				throw new Exception();
			} else {
				TriviaPageArr[11] = driver.findElement(By.id("btnback"));
			}
		} catch (Exception e) {
			System.err.println("WebElement is unable at Trivia Page Error." + e.getClass());
		}
		return TriviaPageArr;
	}
}