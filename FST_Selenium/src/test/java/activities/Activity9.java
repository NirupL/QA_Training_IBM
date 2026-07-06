package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/dynamic-content");

			System.out.println("Title is : " + driver.getTitle());

			driver.findElement(By.id("genButton")).click();

			// Wait until text becomes "release"
			wait.until(ExpectedConditions.textToBe(By.id("word"), "release"));

			// or

//			if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
//				// Print the text to console
//				System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
//			}

			String word = driver.findElement(By.id("word")).getText();

			System.out.println(word);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}
