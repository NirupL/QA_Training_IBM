package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
		
		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/dynamic-attributes");

			System.out.println("Title is : " + driver.getTitle());
			
			driver.findElement(By.xpath("//input[@placeholder = 'Full name']")).sendKeys("abcd");
			
			driver.findElement(By.xpath("//input[@placeholder = 'Email Address']")).sendKeys("abcd@ex.com");
			
			driver.findElement(By.xpath("//input[@data-testid = 'event-date']")).sendKeys("2024-04-23");
			
			driver.findElement(By.xpath("//textarea[contains(@name , '-additional-details-')]")).sendKeys(" abcd ");
			
			driver.findElement(By.xpath("//button[text()= 'Submit']")).click();
			
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
			System.out.println(message);

		
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}

	}

}
