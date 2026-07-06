package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://training-support.net/webelements/mouse-events");

			System.out.println("Title is : " + driver.getTitle());

			
			WebElement cargo_lock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
			WebElement cargo_toml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
			WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
			WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
			
			//left click on the cargo.lock button , move cursor to cargo.toml button and click it
			builder.click(cargo_lock).pause(2000).click(cargo_toml).pause(2000).build().perform();
			
			//print the confirmation command on top 
			String message = driver.findElement(By.id("result")).getText();
			System.out.println(message);
			
			//double click on src button
			builder.doubleClick(src).pause(2000).build().perform();
			
			//right click on the target button and select open
			builder.contextClick(target).pause(2000).perform();
			
			//after the right click the open button is visible on screen and builder can find 
			//and put it in the sequence and executes the click
			builder.click(driver.findElement(By.cssSelector("span.ml-3"))).pause(2000).build().perform();
			
			System.out.println(driver.findElement(By.id("result")).getText());
			
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			driver.quit();
		}
	}

}
