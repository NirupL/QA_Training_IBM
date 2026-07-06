package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
		
		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/keyboard-events");

			System.out.println("Title is : " + driver.getTitle());

			builder.sendKeys("abcd")
				.keyDown(Keys.CONTROL).keyDown(Keys.ENTER)
				.keyUp(Keys.ENTER).keyUp(Keys.CONTROL)
				.build().perform();
			
			System.out.println(driver.findElement(By.id("result")).getText());
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}
