package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity2 {

	public static void main(String[] args) {

		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();
		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//initialize the wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		try {
			// Open the test page
			driver.get(" https://training-support.net/webelements/login-form/");

			System.out.println("Page title is : "+driver.getTitle());
			
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
			
			//explicit wait
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500")));
			
			String succesHeading = driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();
			System.out.println(succesHeading);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		} finally {
			// Close the browser
//			driver.quit(); // close all windows/tab
		}


	}

}
